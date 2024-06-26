package model;

import java.util.Calendar;

public class MyCalendarLogic {
	private LoginUser loginUser;
	public MyCalendarLogic() {

	}
	//引数ある　ログインユーザー情報持ってきている
	public MyCalendarLogic (LoginUser loginUser){
		this.loginUser = loginUser;
	}
	//カレンダーインスタンスを生成するメソッド(int...は可変長引数)
	public MyCalendar createMyCalendar(int... args) {
		//マイカレンダーインスタンス生成
		MyCalendar mc = new MyCalendar();
		//現在日時でカレンダーインスタンス生成
		Calendar cal = Calendar.getInstance();
		//2つの引数が来ていたら
		if (args.length == 2) {
			//最初の引数で年を設定
			cal.set(Calendar.YEAR, args[0]);
			//次の引数で月を設定 args[1]のなかは＋1された月が入っている
			cal.set(Calendar.MONTH, args[1] - 1);
		}
		//年の設定
		mc.setYear(cal.get(Calendar.YEAR));
		//マイカレンダーに月の設定
		mc.setMonth(cal.get(Calendar.MONTH) + 1);
		//その月の1日が何曜日かを調べる為に日付を1日にする
		cal.set(Calendar.DATE, 1);
		//カレンダーの最初の空白の数　DAY_OF_WEEKは現在が週の何日目か
		//例：１週間＝７日、今日が配列で6(金)だとしたら、空白にするのは5日分だから6-1
		int before = cal.get(Calendar.DAY_OF_WEEK) - 1;
		//カレンダーの日付の数　DAY_OF_MONTHは現在の月の何日目か
		int daysCount = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//その月の最後の日が何曜日かを調べるために日付を最終日にする
		cal.set(Calendar.DATE, daysCount);
		//最後の日後の空白の数 一週間７日-(現在が週の何日目か)
		//例：６月は３０が日曜だから週の１日目　7-1=空白6
		int after = 7 - cal.get(Calendar.DAY_OF_WEEK);
		//すべての要素数 前空白＋30日＋後空白
		int total = before + daysCount + after;
		//その要素数を幅7個の配列に入れていった場合何行になるか
		int rows = total / 7;
		//その行数で2次元配列を生成　６行×７日の配列
		String[][] data = new String[rows][7];
		int[][] judge = new int[rows][7];
		//今見ているカレンダーが今月かどうかを調べるために、この瞬間の日付情報をもつもう一つのインスタンス作成しておく
		Calendar now = Calendar.getInstance();
		int m = now.get(Calendar.MONTH);
		int y = now.get(Calendar.YEAR);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < 7; j++) {
				//String mark = "";
				if (i == 0 && j < before || i == rows - 1 && j >= (7 - after)) {
					//カレンダーの前後に入る空白の部分は空文字
					data[i][j] = "";
				} else {
					//カウンター変数と実際の日付の変換
					//６月１日(土)の場合、[0][6]だから0×7+ 6+1 - 前空白6 =1日
					int date = i * 7 + j + 1 - before;
					//配列に日付を入れる
					data[i][j] = String.valueOf(date);

					//todo test用　全部の日を達成にする
					//judge[i][j] = 1; //消す
					judge[i][j] = loginUser.getDayJudge(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, date) ;

					//今作業しているマイカレンダーが今月のカレンダーだったら
					if (m == mc.getMonth() - 1 && y == mc.getYear()) {

						//今日の日付の先頭に*を付与する
						if (now.get(Calendar.DATE) == date && m == mc.getMonth() - 1 && y == mc.getYear()) {
							data[i][j] = "*" + data[i][j];
						//今日の日付以降の先頭に#を付与する
						} else if ((date > now.get(Calendar.DATE))) {
							data[i][j] = "#" + data[i][j];
						}
						//今作業しているマイカレンダーが今月以降のカレンダーだったら
						} else if ((m < mc.getMonth() - 1 && y == mc.getYear()) || y < mc.getYear()) {
						//今月以降の先頭に＄を付与する
							data[i][j] = "$" + data[i][j];
					}
					if(judge[i][j] == 1) {
						data[i][j] = data[i][j] + "@";
					}

				}
			}
		}
		//作成した2次元配列をマイカレンダーにセットする。
		mc.setData(data);
		//mc.setJudge(judge);
		mc.setJudge(judge);
		for(var data1:judge) {
		for(var data2:data1)

		System.out.print(data2);
		System.out.println();

		}
		return mc;
	}
}