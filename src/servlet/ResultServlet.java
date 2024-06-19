package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDao;
import dao.RouteRecordDao;
import model.LoginUser;
import model.Record;
import model.Result;
import model.ResultMessage;
import model.RouteRecord;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクト
		HttpSession session = request.getSession();
		LoginUser loginUser= (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}





		
		
		Calendar nowDate = Calendar.getInstance();
		String year = String.valueOf(nowDate.get(Calendar.YEAR));
		String month = String.valueOf(nowDate.get(Calendar.MONTH)+1);
		String day = String.valueOf(nowDate.get(Calendar.DAY_OF_MONTH));
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		
		
		// リクエストパラメータを取得する
		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");
		request.setAttribute("y", y);
		request.setAttribute("m", m);
		request.setAttribute("d", d);
		
		
		
		//String goalKcal = request.getParameter("goalKcal");
		//String resultKcal = request.getParameter("resultKcal");
		//String record = request.getParameter("record");
		//String route = request.getParameter("route");
		
		//テスト用サンプルデータ ?消す
		double goalKcal = 180;
		double resultKcal = 100;
		
		//int target = (int)(getGoalKcal() - getResultKcal) * 1000 / 30); DBからの情報所得して計算のやつ
		
		//targetを計算してスコープに格納(→jspに表示)
/*		int target = (int)((goalKcal - resultKcal) * 1000 / 30);
		request.setAttribute("targetHosu", target);*/
			    
		
		//DB・DAOで該当日の結果データを検索する
		Result resultData = new Result();//todo:ダミー DBの処理結果に変える
		//検索結果をリクエストスコープに格納する
		request.setAttribute("result", resultData);
		
		
		//DB・DAOで該当日のその他の運動データを検索する
		RecordDao bDao = new RecordDao();
		List<Record> recordData = bDao.collect(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));//？その日の情報に変える
		//検索結果をリクエストスコープに格納する
		request.setAttribute("record", recordData);
		
		//DB・DAOで該当日のその他の運動データを検索する
		RouteRecordDao rDao = new RouteRecordDao();
		List<RouteRecord> routeRecordData = rDao.collect(2024, 6, 19);//？
		//検索結果をリクエストスコープに格納する
		request.setAttribute("routerecord", routeRecordData);
		
		
		//コメント用ランダム 10はコメントの数に変える
		int random = new java.util.Random().nextInt(10) + 1;
/*		if(getComment() == random) {
			String comment = getComment();
		}
		request.setAttribute("comment", comment);*/
		request.setAttribute("random", random);
		
		
		
		
		// 運動結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

	//削除
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクト
		HttpSession session = request.getSession();
		LoginUser loginUser= (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String recordNumber = request.getParameter("record_number");
		String routeNumber = request.getParameter("route_number");
		
		
		
		//削除を行う
		if (request.getParameter("submit").equals("削除1")) {
			RecordDao bDao = new RecordDao();
			if (bDao.delete(Integer.parseInt(recordNumber))){
				request.setAttribute("result",
				new ResultMessage("レコードを削除しました。"));
			}else { // 削除失敗
				request.setAttribute("result",
				new ResultMessage("レコードを削除できませんでした。"));
			}
		}else if(request.getParameter("submit").equals("削除2")) {
			RouteRecordDao  rDao = new RouteRecordDao();
			if (rDao.delete(Integer.parseInt(routeNumber))){  // 削除成功 
				request.setAttribute("result",
				new ResultMessage("レコードを削除しました。"));
			}else{ // 削除失敗
				request.setAttribute("result",
				new ResultMessage("レコードを削除できませんでした。"));
			}
		}

		// 運動結果ページにフォワードする
/*		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);*/
		
		//
		doGet(request, response);
	}
		
}


