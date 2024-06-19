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

@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// セッションスコープの準備
    	HttpSession session = request.getSession();
    	LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
    	loginUser = new LoginUser();

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
    	loginUser = new LoginUser();
    	loginUser.setName(name);
    	loginUser.setHeight(Double.parseDouble(height));
    	loginUser.setWeight(Double.parseDouble(weight));
    	loginUser.setBmi(Double.parseDouble(bmi));

    	UserDao userDao = new UserDao();
    	// boolean result = userDao.update(loginUser, loginUser);
    	// ここにActiveResultを作る
    	doGet(request, response);
    }
}