package model;
import java.io.Serializable;
public class MyCalendar implements Serializable{
	//カレンダーの年
	private int year;
	//カレンダーの月
	private int month;
	//カレンダーの日付を保持する配列
	private String[][] data;

	//カレンダーの日付毎の達成状態を保持する配列
	private int[][] judge;

	/*setter & getter*/
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String[][] getData() {
		return data;
	}
	public void setData(String[][] data) {
		this.data = data;
	}
	public int[][] getJudge() {
		return judge;
	}
	public void setJudge(int[][] judge) {
		this.judge = judge;
	}
}