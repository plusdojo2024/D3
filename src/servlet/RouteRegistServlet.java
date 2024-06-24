package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RouteRecordDao;
import model.LoginUser;
import model.ResultMessage;
import model.RouteRecord;

@WebServlet("/RouteRegistServlet")
public class RouteRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RouteRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar nowDate = Calendar.getInstance();
        String year = String.valueOf(nowDate.get(Calendar.YEAR));
        String month = String.valueOf(nowDate.get(Calendar.MONTH)+1);
        String day = String.valueOf(nowDate.get(Calendar.DAY_OF_MONTH));
        request.setAttribute("year", year);
        request.setAttribute("month", month);
        request.setAttribute("day", day);
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}

		int userNumber = loginUser.getNumber();

		// 履歴の取得
		RouteRecordDao rrDao = new RouteRecordDao();
		List<RouteRecord> rrList = rrDao.select(userNumber);
		if (rrList != null) {
			RouteRecord history = rrList.get(rrList.size()-1); // Listの最終要素を取得する
			request.setAttribute("history", history);
		} else {
			RouteRecord history = null; // 履歴がない場合
			request.setAttribute("history", history);
		}

		// ルート登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/route_regist.jsp");
		dispatcher.forward(request, response);

		/*
            // 読込処理の呼び出し
            RouteRecordLogic logic = newRouteRecordLogic();
            logic.execute(RouteRecord);

            // 読込後のフォワード先設定
            forwardPath = "WEB-INF/jsp/route_regist.jsp";

        } */
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String routeNumber = request.getParameter("routeNumber");
        if (routeNumber == null) {
        	routeNumber = "0";
        }

        // 地図から取得開始
        String startIdo = request.getParameter("my_lat1");
        String startKeido = request.getParameter("my_lng1");
        String endIdo = request.getParameter("my_lat2");
        String endKeido = request.getParameter("my_lng2");
        String distance = request.getParameter("my_distance");
        String spot = request.getParameter("my_route");

        // 地図から取得終了
        String moveKind = request.getParameter("moveKind");
        String kcal = request.getParameter("kcal");


		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		int number			= loginUser.getNumber();
		boolean today_result = false;
		String today_check1      = request.getParameter("today_check");


        // 登録する記録を設定する
        RouteRecord routeRegist = new RouteRecord(
        		Integer.parseInt(routeNumber),
        		Double.parseDouble(startIdo),
        		Double.parseDouble(startKeido),
        		Double.parseDouble(endIdo),
        		Double.parseDouble(endKeido),
        		Double.parseDouble(distance),
        		Integer.parseInt(moveKind),
        		Double.parseDouble(kcal),
        		new Date(),
        		loginUser.getNumber(),
        		spot);

        // 入力を判定する



        // エラーがあった場合登録しない
        // エラーがなければDBへ登録する
        RouteRecordDao rrDao = new RouteRecordDao();
		if(rrDao.insert(routeRegist)) {
			request.setAttribute("result", new ResultMessage("登録されました"));
		}else {
			request.setAttribute("result", new ResultMessage("登録されませんでした"));
		}
        // 入力情報のフォワード先
        // 確認ダイアログを表示する？
        doGet(request, response);

    }
}