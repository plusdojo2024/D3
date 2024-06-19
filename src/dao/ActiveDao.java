package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Active;

public class ActiveDao {
	public  ArrayList<Active> getActiveList(){
		Connection conn = null;
		ArrayList<Active> acList = new ArrayList<Active>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL
			String sql = "SELECT * FROM Active";
			PreparedStatement pStmt =conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				Active acRecord = new Active(
					rs.getInt("active_number"),
					rs.getInt("kind"),
					rs.getDouble("mets_value"),
					rs.getString("name")
				);
				acList.add(acRecord);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			acList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			acList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					acList = null;
				}
			}
		}

		// 結果を返す
		return acList;
	}
}
