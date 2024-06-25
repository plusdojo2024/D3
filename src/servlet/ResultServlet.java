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

import dao.DayResultDao;
import dao.RecordDao;
import dao.RouteRecordDao;
import dao.UserDao;
import model.Comment;
import model.DayResult;
import model.Level;
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
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしてなかったらログインサーブレットにリダイレクト
		HttpSession session = request.getSession();
		LoginUser loginUser= (LoginUser)session.getAttribute("loginUser");
		if (loginUser == null) {
			response.sendRedirect("/D3/LoginServlet");
			return;
		}


		// リクエストパラメータを取得する
		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");
		
		if(y==null || m==null || d == null
				|| "".equals(y)|| "".equals(m)|| "".equals(d)) {
			
			Calendar cal2 = Calendar.getInstance();
			
			y = String.valueOf(cal2.get(Calendar.YEAR));
			m = String.valueOf(cal2.get(Calendar.MONTH)+1);
			d = String.valueOf(cal2.get(Calendar.DAY_OF_MONTH));	
		}
		
		request.setAttribute("y", y);
		request.setAttribute("m", m);
		request.setAttribute("d", d);


		List<Level> lvList = loginUser.getLvList();
		//session.setAttribute("id", new LoginUser(id));
		
		//レベル、目標カロリー、次のレベルまでの達成日数を受け取る部分
		int number = loginUser.getNumber();
		int userLevel = loginUser.getUserLevel();
		Level levelInfo = loginUser.getPickupLvList(userLevel);
		double goalKcal = levelInfo.getGoalKcal();
		double resultKcal = 0;//ここ計算にする？
		int userExp = 0;// = loginUser.getUserExp();
		int nextLevelExp = levelInfo.getNextLevelExp();
		
		request.setAttribute("userLevel", userLevel);
		request.setAttribute("goalKcal", goalKcal);
		
		
		java.sql.Date thisDate= java.sql.Date.valueOf(y +"-"+ m +"-"+ d);
		
		//セッションスコープの更新
/*		loginUser.setDrList(drList);
		session.setAttribute("loginUser",loginUser);*/

		
		
		//DB・DAOで該当日の結果データを検索する
		Result resultData = new Result();//todo:ダミー DBの処理結果に変える
		request.setAttribute("result", resultData);
		
		
		//DB・DAOで該当日のその他の運動データを検索する
		RecordDao bDao = new RecordDao();
		List<Record> recordData = bDao.collect(number, Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));
		request.setAttribute("record", recordData);
		
		//今日の消費カロリー計算
		for(Record record : recordData) {
			resultKcal += record.getKcal();
		}
		
		
		//DB・DAOで該当日のマップ入力運動データを検索する
		RouteRecordDao rDao = new RouteRecordDao();
		List<RouteRecord> routeRecordData = rDao.collect(number, Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));
		request.setAttribute("routerecord", routeRecordData);
		
		System.out.println(routeRecordData.size());
		
		//今日の消費カロリー計算　ルートも
		for(RouteRecord routeRecord : routeRecordData) {
			resultKcal += routeRecord.getKcal();
		}

		//消費カロリーをリクエストスコープに
		request.setAttribute("resultKcal", resultKcal);
	
		
		//１日分のDayResultのデータ受け取り ?
		DayResultDao tdrDao = new DayResultDao();
		List<DayResult> tdrList = tdrDao.getDayResultList(loginUser.getNumber(), Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(d));

				
		if(tdrList.size() ==1) {
			DayResult dr = tdrList.get(0);
			dr.setResultKcal(resultKcal);
			dr.setGoalKcal(goalKcal);
			dr.setJudge((goalKcal <= resultKcal) ? 1 : 0);
			tdrDao.update(dr);
		}else {
			DayResult dr = new DayResult(
				thisDate,
				goalKcal,
				resultKcal,
				(goalKcal <= resultKcal) ? 1 : 0,
				number
			); 
			tdrDao.insert(dr);			
		}
		
		
		//DayResultのデータ受け取り
		DayResultDao drDao = new DayResultDao();
		List<DayResult> drList = drDao.getDayResultList(loginUser.getNumber());

		//累計達成日を計算してレベル上げる→登録
		for(DayResult dayResult : drList) {
			userExp = userExp + dayResult.getJudge();
		}
		
		if(userExp >= nextLevelExp) {
			userLevel = userLevel + 1 ;
			loginUser.setUserLevel(userLevel);
			UserDao udao = new UserDao();
			udao.updateUser(loginUser);
		}
		
		
		//セッションスコープの更新
/*		loginUser.setDrList(drList);
		session.setAttribute("loginUser",loginUser);*/
		
		
		//コメント用ランダム 8はコメントの数に変える
		int random = new java.util.Random().nextInt(8) + 1;		
		//コメントデータをセッションスコープから受け取る
		Comment comment = loginUser.getPickupComList(random);
		String randomCom = comment.getCommentValue();
		request.setAttribute("randomcom", randomCom);
		

		// 運動結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

	//削除機能
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
		RecordDao bDao = new RecordDao();
		RouteRecordDao  rDao = new RouteRecordDao();

		String type = request.getParameter("type");
		if (type.equals("1")) {
			if (bDao.delete(Integer.parseInt(recordNumber))){
				request.setAttribute("ResultMessage", new ResultMessage("レコードを削除しました。"));
			}else { // 削除失敗
				request.setAttribute("ResultMessage", new ResultMessage("レコードを削除できませんでした。"));
			}
		}else if(type.equals("2")) {
			if (rDao.delete(Integer.parseInt(routeNumber))){  // 削除成功 
				request.setAttribute("ResultMessage", new ResultMessage("レコードを削除しました。"));
			}else{ // 削除失敗
				request.setAttribute("ResultMessage", new ResultMessage("レコードを削除できませんでした。"));
			}
		}

		// 運動結果ページにフォワードする
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);*/
		
		//
		doGet(request, response);
	}
		
}


