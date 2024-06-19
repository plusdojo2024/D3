package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comment;

public class CommentDao {
	public  ArrayList<Comment> getCommentList(){
		Connection conn = null;
		ArrayList<Comment> comList = new ArrayList<Comment>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL
			String sql = "SELECT * FROM Comment";
			PreparedStatement pStmt =conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				Comment comRecord = new Comment(
					rs.getInt("comment_number"),
					rs.getString("comment_value")
				);
				comList.add(comRecord);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			comList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			comList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					comList = null;
				}
			}
		}

		// 結果を返す
		return comList;
	}
}
