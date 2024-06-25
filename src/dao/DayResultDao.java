package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.DayResult;

public class DayResultDao {
	
		// 引数sportで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(DayResult sport) {
			Connection conn = null;
			boolean result = false;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのACTIVE_NUMBER列にはNULLを指定する）
				String sql = "INSERT INTO Day_Result VALUES (?, ?, ?, ?, ? )";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setDate(0, new java.sql.Date(sport.getDate().getTime()));
				pStmt.setDouble(1, sport.getGoalKcal());
				pStmt.setDouble(2, sport.getResultKcal());
				pStmt.setInt(3, sport.getJudge());
				pStmt.setInt(4, sport.getNumber());
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

		
		
		//DayResultを得る
		public List<DayResult> getDayResultList(int num) {//ymd
			Connection conn = null;
			List<DayResult> DayResultList = new ArrayList<>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM Day_Result WHERE number = ? ";
				
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setInt(1, num);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
		        //java.util.Date date2 = new java.util.Date(date1.getTime());
				
				while (rs.next()) {
					DayResult dayResult = new DayResult(
						new java.util.Date(rs.getDate("date").getTime()),
						rs.getDouble("goal_kcal"),
						rs.getDouble("result_kcal"),
						rs.getInt("judge"),
						rs.getInt("number"));
					DayResultList.add(dayResult);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				DayResultList.clear();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				DayResultList.clear();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						DayResultList.clear();
					}
				}
			}

			// 結果を返す
			return DayResultList;
			

		}	
		
		//引数に日付あり　その日だけのDayResult得る
		public List<DayResult> getDayResultList(int num, int y, int m, int d) {//ymd
			Connection conn = null;
			List<DayResult> DayResultList = new ArrayList<>();

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, y);
			cal.set(Calendar.MONTH, m);
			cal.set(Calendar.DATE, d);

			
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM Day_Result WHERE number = ? date = ?";
				
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setInt(1, num);
				pStmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
		        //java.util.Date date2 = new java.util.Date(date1.getTime());
				
				if (rs.next()) {
					DayResult dayResult = new DayResult(
						new java.util.Date(rs.getDate("date").getTime()),
						rs.getDouble("goal_kcal"),
						rs.getDouble("result_kcal"),
						rs.getInt("judge"),
						rs.getInt("number"));
					DayResultList.add(dayResult);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				DayResultList.clear();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				DayResultList.clear();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						DayResultList.clear();
					}
				}
			}

			// 結果を返す
			return DayResultList;
			

		}	
		
		
		
		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(DayResult sport) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

				// SQL文を準備する
				String sql = "UPDATE Day_result SET goal_kcal=?, result_kcal=?, judge=? WHERE number=? and date = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setDouble(1, sport.getGoalKcal());
				pStmt.setDouble(2, sport.getResultKcal());
				pStmt.setInt(3, sport.getJudge());
				pStmt.setInt(4, sport.getNumber());
			    java.sql.Date sqlDate = new java.sql.Date(sport.getDate().getTime());
				pStmt.setDate(5, sqlDate);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
}