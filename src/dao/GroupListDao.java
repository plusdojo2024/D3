package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GroupList;
import model.LoginUser;

public class GroupListDao {
	public  ArrayList<GroupList> getGroupList(LoginUser loginUser){
		Connection conn = null;
		ArrayList<GroupList> groupList = new ArrayList<GroupList>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL
			String sql = "SELECT * FROM Group_list WHERE number=?";
			PreparedStatement pStmt =conn.prepareStatement(sql);
			pStmt.setInt(1, loginUser.getNumber());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				GroupList glRecord = new GroupList(
					rs.getInt("group_number"),
					rs.getInt("group_id"),
					rs.getString("group_name")
				);
				groupList.add(glRecord);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			groupList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			groupList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					groupList = null;
				}
			}
		}

		// 結果を返す
		return groupList;
	}
}
