package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			//？？？？
		request.setCharacterEncoding("UTF-8");
		//String target = request.getParameter("target");
		String goalKcal = request.getParameter("goalKcal");
		//String resultKcal = request.getParameter("resultKcal");
		//String record = request.getParameter("record");
		//String route = request.getParameter("route");
		int userLevel = session.getAttribute("/**/")
		
		//DB・DAOで該当日の結果データを検索する
		
		Result resultData = new Result();//todo:ダミー　DBの処理結果に変える
		
		//検索結果をリクエストスコープに格納する

		request.setAttribute("result", resultData);
		
		// 運動結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/simpleBC/LoginServlet");
			return;
		}
		
	
		
	}

}
