package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.h2.engine.Setting;

import model.User;

@WebServlet("/SettingServlet")
public class SettingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // サーブレットクラスの動作を決定する「action」の値をリクエストパラメータから取得
        String action = request.getParameter("action");

        if(action == null) {
            forwardPath = "/WEB-INF/jsp/setting.jsp";
        }

        else if(action.equals("done")) {
            // セッションスコープからユーザー情報を取得する
            HttpSession session = request.getSession();
            User setting = (Setting) session.getAttribute("name");
            User setting = (Setting) session.getAttribute("height");
            User setting = (Setting) session.getAttribute("weight");
            User setting = (Setting) session.getAttribute("bmi");

            // 登録処理の呼び出し
            SettingLogic logic = newSettingLogic();
            logic.execute(Setting);

            // 登録後のフォワード先設定
            forwardPath = "WEB-INF/jsp/setting.jsp";
        }

        // 設定されたフォワード先に遷移
        RequestDispatcher dispatcher = request.getRequestDiscpatcher(forwardPath);
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        double height = request.getParameter("height");
        double weight = request.getParameter("weight");

        // 登録するユーザー情報を設定
        User setting = new Setting(name, height, weight);

        // セッションスコープにユーザー情報を保存
        HttpSession session = request.getSession();
        session.setAttribute("setting", setting);

        // 登録後のフォワード先
        forwardPath = "WEB-INF/jsp/setting.jsp";
        RequestDispatcher dispatcher = request.getRequestDiscpatcher("/WEB-INF/jsp/setting.jsp");
        dispatcher.forward(request, response);
    }
}