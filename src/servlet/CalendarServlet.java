package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MyCalendar;
import model.MyCalendarLogic;

@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession();
		//= ()session.getAttribute("");
		String s_year=request.getParameter("year");
		String s_month=request.getParameter("month");
		MyCalendarLogic logic=new MyCalendarLogic();
		MyCalendar mc=null;
		if(s_year != null && s_month != null) {
			int year =Integer.parseInt(s_year);
			int month=Integer.parseInt(s_month);
			if(month==0) {
				month=12;
				year--;
			}
			if(month==13) {
				month=1;
				year++;
			}
			//年と月のクエリパラメーターが来ている場合にはその年月でカレンダーを生成する
			mc=logic.createMyCalendar(year,month);
		}else {
			//クエリパラメータが来ていないときは実行日時のカレンダーを生成する。
			mc=logic.createMyCalendar();
		}

		//リクエストスコープに格納
		String judge=request.getParameter("judge");
		request.setAttribute("mc", mc);
		request.setAttribute("judge", judge);

		Calendar nowDate = Calendar.getInstance();
		String year = String.valueOf(nowDate.get(Calendar.YEAR));
		String month = String.valueOf(nowDate.get(Calendar.MONTH)+1);
		String day = String.valueOf(nowDate.get(Calendar.DAY_OF_MONTH));
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);

		//jspにフォワード
		RequestDispatcher rd=request.getRequestDispatcher("./WEB-INF/jsp/calender.jsp");
		rd.forward(request, response);
	}
}