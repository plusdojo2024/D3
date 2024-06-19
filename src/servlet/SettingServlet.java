package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.LoginUser;
import model.ResultMessage;

@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}
    	// セッションスコープの準備
        String setting1 = loginUser.getName();
        Double setting2 = loginUser.getHeight();
        Double setting3 = loginUser.getWeight();
        Double setting4 = loginUser.getBmi();

        request.setAttribute("number", loginUser.getNumber());
        request.setAttribute("name", setting1);
        request.setAttribute("height", setting2);
        request.setAttribute("weight", setting3);
        request.setAttribute("bmi", setting4);

    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/setting.jsp");
    	dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String bmi = request.getParameter("bmi");
        String number = request.getParameter("number");

        // 登録するユーザー情報を設定
    	HttpSession session = request.getSession();
    	LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
    	loginUser.setName(name);
    	loginUser.setHeight(Double.parseDouble(height));
    	loginUser.setWeight(Double.parseDouble(weight));
    	loginUser.setBmi(Double.parseDouble(bmi));

    	UserDao userDao = new UserDao();
    	try {
    		userDao.updateUser(loginUser, loginUser);
    		request.setAttribute("result", new ResultMessage("ユーザー情報を変更しました。"));
    	}
    	catch (Exception ex) {
			request.setAttribute("result", new ResultMessage("を削除できませんでした。"));
    	}

    	doGet(request, response);
    }
}