package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Record;
import model.Result;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		session.setAttribute("id","dummy");//todo:ダミー
		if (session.getAttribute("id") == null) {
			response.sendRedirect("./LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		//request.setCharacterEncoding("UTF-8");
		//String target = request.getParameter("target");
		//String goalKcal = request.getParameter("goalKcal");
		//String resultKcal = request.getParameter("resultKcal");
		//String record = request.getParameter("record");
		//String route = request.getParameter("route");
		//int userLevel = session.getAttribute("/**/")
		
		//テスト用サンプルデータ ?消す
		double goalKcal = 180;
		double resultKcal = 100;
		
		//int target = (int)(getGoalKcal() - getResultKcal) * 1000 / 30); DBからの情報所得して計算のやつ
		
		//targetを計算してスコープに格納(→jspに表示)
		int target = (int)((goalKcal - resultKcal) * 1000 / 30);
		request.setAttribute("targetHosu", target);
		
		
		//DB・DAOで該当日の結果データを検索する
		Result resultData = new Result();//todo:ダミー DBの処理結果に変える
		//検索結果をリクエストスコープに格納する
		request.setAttribute("result", resultData);
		
		
		//DB・DAOで該当日のその他の運動データを検索する
		Record recordData = new Record();//todo:ダミー DBの処理結果に変える
		//検索結果をリクエストスコープに格納する
		request.setAttribute("record", recordData);
		
		
		
		//コメント用ランダム 10はコメントの数に変える
		int comRandom = new java.util.Random().nextInt(10) + 1;
		
		
		// 運動結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

	//削除
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		session.setAttribute("id","dummy");//todo:ダミー
		if (session.getAttribute("id") == null) {
			response.sendRedirect("./LoginServlet");
			return;
		}
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		
		
		
		
/*		//削除を行う
		RecordDao bDao = new RecordDao();
		RouteRecordDao  rDao = new RouteRecordDao();
		if (request.getParameter("submit").equals("削除")) {
			if (bDao.delete(record_number) || rDao.delete(Route_number)) { // 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "レコードを削除しました。", "/D3/ResultServlet"));
			}
			else { // 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "レコードを削除できませんでした。", "/D3/ResultServlet"));
			}
		}
*/
		// 運動結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
		
}


