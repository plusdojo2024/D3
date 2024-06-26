package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RecordDao;
import model.Active;
import model.LoginUser;
import model.Record;
import model.ResultMessage;


/**
 * Servlet implementation class ActiveRegistServlet
 */
@WebServlet("/ActiveRegistServlet")
public class ActiveRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする


		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}
		//セッションスコープのデータを受け取る
//		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
//		List<Active> acList = loginUser.getAcList();
//		session.setAttribute("id", new LoginUser(id));

		//運動名、メッツ値、運動番号、運動種類を受け取る部分
		Active a1 = loginUser.getPickupAcList(1);
		request.setAttribute("a1", a1);
		Active a2 = loginUser.getPickupAcList(2);
		request.setAttribute("a2", a2);
		Active a3 = loginUser.getPickupAcList(3);
		request.setAttribute("a3", a3);
		Active a4 = loginUser.getPickupAcList(4);
		request.setAttribute("a4", a4);
		Active a5 = loginUser.getPickupAcList(5);
		request.setAttribute("a5", a5);
		Active a6 = loginUser.getPickupAcList(6);
		request.setAttribute("a6", a6);
		Active a7 = loginUser.getPickupAcList(7);
		request.setAttribute("a7", a7);
		Active a8 = loginUser.getPickupAcList(8);
		request.setAttribute("a8", a8);
		Active a9 = loginUser.getPickupAcList(9);
		request.setAttribute("a9", a9);
		Active a10 = loginUser.getPickupAcList(10);
		request.setAttribute("a10", a10);
		Active a11 = loginUser.getPickupAcList(11);
		request.setAttribute("a11", a11);
		Active a12 = loginUser.getPickupAcList(12);
		request.setAttribute("a12", a12);
		Active a13 = loginUser.getPickupAcList(13);
		request.setAttribute("a13", a13);
		Active a14 = loginUser.getPickupAcList(14);
		request.setAttribute("a14", a14);
		Active a15 = loginUser.getPickupAcList(15);
		request.setAttribute("a15", a15);

		double height = loginUser.getHeight();
		request.setAttribute("height", height);
		double weight = loginUser.getWeight();
		request.setAttribute("weight", weight);







		Calendar nowDate = Calendar.getInstance();
		String year = String.valueOf(nowDate.get(Calendar.YEAR));
		String month = String.valueOf(nowDate.get(Calendar.MONTH)+1);
		String day = String.valueOf(nowDate.get(Calendar.DAY_OF_MONTH));
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);


		// その他入力ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/active_regist.jsp");
		dispatcher.forward(request, response);
	}

    public ActiveRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {






		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
		int number			= loginUser.getNumber();
		boolean[] result = {false, false, false};
		String check1      = request.getParameter("check1");
		if ("1".equals(check1)) {
			String activeNumber1      = request.getParameter("active_number1");
			String time1      			= request.getParameter("time1");
			String step1      			= request.getParameter("step1");
			String kcal1     			 = request.getParameter("kcal1");
			String[]activeNumber = activeNumber1.split("&&");
			Active active  	= loginUser.getPickupAcList(Integer.parseInt(activeNumber[3]));
			int kind 		 	= active.getKind();
			double value 	 	= 0.0;
			String unit = "";
			if(time1 == null) {						//時間フォームが空だった場合
				value = Double.parseDouble(step1);
				unit = "歩";
			}else {
				value = Double.parseDouble(time1);
				unit = "分";
			}

			Date registDate  	= new Date();


			double kcal 		= Double.parseDouble(kcal1);
			RecordDao bDao = new RecordDao();
			result[0] = bDao.insert(new Record(0, kind, value , unit, registDate, number, kcal,activeNumber[2])  );

			}else {
			result[0] = true;
		}
			//二つ目のチェックボックス
		String check2      = request.getParameter("check2");
		if ("2".equals(check2)) {
			String activeNumber2      = request.getParameter("active_number2");
			String time2      = request.getParameter("time2");
			String step2      = request.getParameter("step2");
			String kcal2      = request.getParameter("kcal2");
			//Active active  	= new Active(1,1,1.0, "サッカー" ); //セッションに入っているマスターデータを取得する
			String[]activeNumber = activeNumber2.split("&&");
			Active active  	= loginUser.getPickupAcList(Integer.parseInt(activeNumber[3]));
			int kind 		 	= active.getKind();
			double value 	 	= 0.0;
			String unit = "";
			if(time2 ==null) {
				value = Double.parseDouble(step2);
				unit = "歩";
			}else {
				value = Double.parseDouble(time2);
				unit = "分";
			}

			Date registDate  	= new Date();
			//LoginUser loginUser = (LoginUser)session.getAttribute("id");
			//LoginUser loginUser = new LoginUser(1);//ログインが完成したら削除する部分
			//int number			= loginUser.getId();

			double kcal 		= Double.parseDouble(kcal2);
			RecordDao bDao = new RecordDao();
			result[1] = bDao.insert(new Record(0, kind, value , unit, registDate, number, kcal,activeNumber[2]) );

			}else {
				result[1] = true;
			}
			//３つ目のチェックボックス
		String check3      			   = request.getParameter("check3");
		if ("3".equals(check3)) {
			String activeNumber3      = request.getParameter("active_number3");
			String time3      		   = request.getParameter("time3");
			String step3      		   = request.getParameter("step3");
			String kcal3      		   = request.getParameter("kcal3");

			//Active active  	= new Active(1,1,1.0, "サッカー" ); //セッションに入っているマスターデータを取得する
			String[]activeNumber = activeNumber3.split("&&");
			Active active  	= loginUser.getPickupAcList(Integer.parseInt(activeNumber[3]));

			int kind 		 	= active.getKind();
			double value 	 	= 0.0;
			String unit = "";
			if(time3 ==null) {
				value = Double.parseDouble(step3);
				unit = "歩";
			}else {
				value = Double.parseDouble(time3);
				unit = "分";
			}

			Date registDate  	= new Date();
			//LoginUser loginUser = (LoginUser)session.getAttribute("loginUser");
			//LoginUser loginUser = new LoginUser(1);//ログインが完成したら削除する部分
			//int number			= loginUser.getId();

			double kcal 		= Double.parseDouble(kcal3);
			RecordDao bDao = new RecordDao();
			result[2] = bDao.insert(new Record(0, kind, value , unit, registDate, number, kcal,activeNumber[2]) );

		}else {
			result[2] = true;
		}
/*		int kind 		 	= Integer.parseInt(request.getParameter("kind"));
		double value 	 	= Double.parseDouble(request.getParameter("value"));
		String unit 	 	= request.getParameter("unit");
		Date registDate  	= new Date();
		int number		 	=Integer.parseInt(request.getParameter("number"));
		double kcal 		= Double.parseDouble(request.getParameter("value"));
		String check2      = request.getParameter("check1");
		String check3      = request.getParameter("check1");
		String step2      = request.getParameter("step2");
		String step3      = request.getParameter("step3");
		*/

		// 登録処理を行う
		if (!result[0] || !result[1] || !result[2]) {	// 登録成功
			request.setAttribute("result",
			new ResultMessage("運動記録を登録できませんでした")); // ResultMessage,javaからメッセージを
		}else {												// 登録失敗
			request.setAttribute("result",
			new ResultMessage("運動記録を登録しました"));	// ResultMessage,javaからメッセージを表示
		}
		// その他入力ページに戻る
		doGet(request, response);
	}

}
