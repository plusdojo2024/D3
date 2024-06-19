package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Level;

public class LevelDao {
	public  ArrayList<Level> getLevelList(){
		Connection conn = null;
		ArrayList<Level> lvList = new ArrayList<Level>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL
			String sql = "SELECT * FROM Level";
			PreparedStatement pStmt =conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				Level lvRecord = new Level(
					rs.getInt("level"),
					rs.getDouble("goal_kcal"),
					rs.getInt("next_level_exp")
				);
				lvList.add(lvRecord);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			lvList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			lvList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					lvList = null;
				}
			}
		}

		// 結果を返す
		return lvList;
	}
}
