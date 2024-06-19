package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;

import dao.RouteRecordDao;
import dao.RecordDao;

@WebServlet("/RouteRegistServlet");
public class RouteRegistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
		session.setAttribute("id","dummy");//todo:ダミー
		if (session.getAttribute("id") == null) {
			response.sendRedirect("./LoginServlet");
			return;
		}

        // サーブレットクラスの動作を決定する「action」の値をリクエストパラメータから取得
        String action = request.getParameter("action");

        if(action == null) {
            forwardPath = "/WEB-INF/jsp/route_regist.jsp";
        }

        else if(action.equals("done")) {
            // セッションスコープからルート記録の履歴を取得する
            HttpSession session = request.getSession();
            RouteRecord routeRegist = (RouteRecord) session.getAttribute("routeRecord");
            Int routeRegist1 = routeRecord.getrouteNumber();
            Double routeRegist2 = routeRecord.getstartIdo();
            Double routeRegist3 = routeRecord.getstartKeido();
            Double routeRegist4 = routeRecord.getendIdo();
            Double routeRegist5 = routeRecord.getendKeido();
            Double routeRegist6 = routeRecord.getdistance();
            Int routeRegist7 = routeRecord.getmoveKind();
            Double routeRegist8 = routeRecord.getkcal();
            Date routeRegist9 = routeRecord.getregistDate();
            Int routeRegist10 = routeRecord.getnumber();
            Varchar routeRegist11 = routeRecord.getspot();

            // 読込処理の呼び出し
            RouteRecordLogic logic = newRouteRecordLogic();
            logic.execute(RouteRecord);

            // 読込後のフォワード先設定
            forwardPath = "WEB-INF/jsp/route_regist.jsp";

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        Int number = request.getParameter("routeNumber");
        double startIdo = request.getParameter("startIdo");
        double startKeido = request.getParameter("startKeido");
        double endIdo = request.getParameter("endIdo");
        double endKeido = request.getParameter("endKeido");
        double distance = request.getParameter("distance");
        Int moveKind = request.getParameter("moveKind");
        double getKcal = request.getParameter("getKcal");
        Date registDate = request.getParameter("registDate");
        Int number = request.getParameter("number");
        Varchar spot = request.getParameter("spot");

        // 登録する記録を設定する
        RouteRecord routeRegist = new RouteRegist(routeNumber, startIdo, startKeido, endIdo, endKeido, distance, moveKind, kcal, registDate, number, spot);

        // 入力を判定する


        // エラーがあった場合登録しない

        // 入力情報のフォワード先
        forwardPath = "WEB-INF/jsp/route_regist.jsp";
        RequestDispatcher dispatcher = request.getRequestDiscpatcher("/WEB-INF/jsp/route_regist.jsp");
        dispatcher.forward(request, response);


        // 確認ダイアログを表示する

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 履歴データをインポート
    }
}