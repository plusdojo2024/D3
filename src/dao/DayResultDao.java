package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
				String sql = "INSERT INTO DayResult VALUES (?, ?, ?, ?, ? )";
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

}
