package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Record;

public class RecordDao {

	// 引数sportで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Record sport) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのACTIVE_NUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Record VALUES (NULL, ?, ?, ?, ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, sport.getKind());
			pStmt.setDouble(2, sport.getValue());
			if (sport.getUnit() != null && !sport.getUnit().equals("")) {
				pStmt.setString(3, sport.getUnit());
			}
			else {
				pStmt.setString(3, "（未設定）");
			}
			pStmt.setDate(4, new java.sql.Date(sport.getRegistDate().getTime()));
			pStmt.setInt(5, sport.getNumber());
			pStmt.setDouble(6, sport.getKcal());
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


	public boolean delete(int number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM Record WHERE record_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, number);

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
