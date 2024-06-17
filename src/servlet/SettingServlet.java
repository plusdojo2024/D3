package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BcDAO;
import model.Bc;
import model.Result;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

        /**
     * @see HttpServlet#HttpServlet()
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}

		// ユーザー設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/setting.jsp");
		dispatcher.forward(request, response);
	}

    	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
        double height = request.getParameter("height");
        double weight = request.getParameter("weight");
		double bmi = request.getParameter("bmi");

		// 更新処理を行う
		UserDAO bDao = new UserDAO();
		if (bDao.insert(new User(name, height, weight, bmi,))) {	// 更新成功
			request.setAttribute("result",
			new ActionResult( "更新が実行されました。"));
		}
		else {												// 更新失敗
			request.setAttribute("result",
			new ActionResult("更新されませんでした。"));
		}

		// ユーザー設定ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/setting.jsp");
		dispatcher.forward(request, response);
	}
}

