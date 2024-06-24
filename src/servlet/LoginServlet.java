package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// この続きにセッションスコープに入れるデータに関連したファイルをインポート
// マスターデータ
import dao.ActiveDao;
import dao.CommentDao;
import dao.LevelDao;
import dao.UserDao;
import model.LoginError;
import model.LoginUser;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// ログイン処理を行う
		UserDao uDao = new UserDao();
		if (uDao.isLoginOK(new User(id, password))) {	// ログイン成功
			// セッションスコープに格納する準備
			HttpSession session = request.getSession();			// セッションスコープの保存領域確保

			User user = uDao.getUser(new User(id, password));	// ログインしたユーザーの情報取得
			LoginUser loginUser = new LoginUser(user);			// 取得した情報をログインしたユーザーに格納

			// ここにログイン時にセッションスコープに入れておくマスターデータを記述する
			LevelDao lvDao = new LevelDao();
			CommentDao cDao = new CommentDao();
			ActiveDao aDao = new ActiveDao();
//			GroupListDao glDao = new GroupListDao();
			loginUser.setLvList(lvDao.getLevelList());
			loginUser.setComList(cDao.getCommentList());
			loginUser.setAcList(aDao.getActiveList());
//			loginUser.setGlList(glDao.getGroupList(loginUser));

			// セッションスコープに格納
			session.setAttribute("loginUser", loginUser);

			//HttpSession session = request.getSession();	// セッションスコープの準備
			//LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");	// 更新前のユーザー情報を準備
			//loginUser.set○○();	// 更新後の情報をセットする
			//UserDao uDao = new UserDao();	// UserDaoを準備
			//boolean updateOk = false;	// 更新の成否を入れる変数を準備
			//UpdateUser updateUser = uDao.updateUser(user, loginUser);	// 更新のメソッド実行
			//updateOk = updateUser.isUpdateOk();	// 更新の成否を格納
			/*
			// 成否を判断してそれに合ったメッセージをリクエストスコープに格納
			if(updateOk){
				request.setAttribute("resultMessage", new ResultMessage("更新成功です"));
				loginUser.set○○(updateUser.get○○());	// 更新後のユーザー情報を格納
				session.setAttribute("loginUser", loginUser);	// 更新したユーザー情報をセッションスコープに格納
			} else{
				request.setAttribute("resultMessage", new ResultMessage("更新に失敗しました"));
			}
			*/

			// ResultServletにリダイレクトする
			Calendar nowDate = Calendar.getInstance();
			String year = String.valueOf(nowDate.get(Calendar.YEAR));
			String month = String.valueOf(nowDate.get(Calendar.MONTH)+1);
			String day = String.valueOf(nowDate.get(Calendar.DAY_OF_MONTH));
//			request.setAttribute("year", year);
//			request.setAttribute("month", month);
//			request.setAttribute("day", day);

			response.sendRedirect("/D3/ResultServlet?y="+ year +"&m="+ month +"&d="+ day);
		}
		else {											// ログイン失敗
			// リクエストスコープに、メッセージを格納する
			request.setAttribute("loginError",
			new LoginError("IDまたはPasswordに間違いがあります"));

			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);

		}
	}

}
