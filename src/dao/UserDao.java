package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginUser;
import model.UpdateUser;
import model.User;

public class UserDao {
	// ログインできるならtrueを返す
	public boolean isLoginOK(User user) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM User WHERE id = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	// ログインしたユーザーの情報を取得する
	public  User getUser(User user){
		Connection conn = null;
		User loginUser = new User();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM User WHERE id = ? AND password = ?";
			PreparedStatement pStmt =conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPassword());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
				User userRecord = new User(
					rs.getInt("number"),
					rs.getString("id"),
					rs.getString("password"),
					rs.getString("user_name"),
					rs.getDouble("height"),
					rs.getDouble("weight"),
					rs.getDouble("bmi"),
					rs.getInt("user_level"),
					rs.getInt("user_exp")
				);
				loginUser = userRecord;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginUser = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginUser = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginUser = null;
				}
			}
		}

		// 結果を返す
		return loginUser;
	}

	// ユーザーの情報を更新して、更新後のデータを取得する
	public  UpdateUser updateUser(User user, LoginUser loginUser){
		Connection conn = null;
		UpdateUser updateUser = new UpdateUser();
		boolean result = false;
		int diff = 1;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE User SET user_name=?, height=?, weight=?, bmi=?, user_level=?, user_exp=? WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (!user.getName().equals(loginUser.getName())) {
				pStmt.setString(1, user.getName());
			}
			else {
				pStmt.setString(1, loginUser.getName());
			}
			diff = Double.compare(user.getHeight(), loginUser.getHeight());
			if (diff == 0) {
				pStmt.setDouble(2, user.getHeight());
				diff = 1;
			}
			else {
				pStmt.setDouble(2, loginUser.getHeight());
			}
			diff = Double.compare(user.getWeight(), loginUser.getWeight());
			if (diff == 0) {
				pStmt.setDouble(3, user.getWeight());
				diff = 1;
			}
			else {
				pStmt.setDouble(3, loginUser.getWeight());
			}
			diff = Double.compare(user.getBmi(), loginUser.getBmi());
			if (diff == 0) {
				pStmt.setDouble(4, user.getBmi());
				diff = 1;
			}
			else {
				pStmt.setDouble(4, loginUser.getBmi());
			}
			diff = Double.compare(user.getUserLevel(), loginUser.getUserLevel());
			if (diff == 0) {
				pStmt.setDouble(5, user.getUserLevel());
				diff = 1;
			}
			else {
				pStmt.setDouble(5, loginUser.getUserLevel());
			}
			diff = Double.compare(user.getUserExp(), loginUser.getUserExp());
			if (diff == 0) {
				pStmt.setDouble(6, user.getUserExp());
				diff = 1;
			}
			else {
				pStmt.setDouble(6, loginUser.getUserExp());
			}
			pStmt.setInt(7, loginUser.getNumber());

			// SQL文を実行する（→成功なら更新されたデータを取得する）
			if (pStmt.executeUpdate() == 1) {
				result = true;
				// SQL文を準備する
				String sql2 = "SELECT * FROM User WHERE user_number=?";
				PreparedStatement pStmt2 =conn.prepareStatement(sql2);
				pStmt.setInt(1, loginUser.getNumber());
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt2.executeQuery();
				// 結果表をコレクションにコピーする
				while(rs.next()) {
					User uur = new User(
						rs.getInt("number"),
						rs.getString("id"),
						rs.getString("password"),
						rs.getString("user_name"),
						rs.getDouble("height"),
						rs.getDouble("weight"),
						rs.getDouble("bmi"),
						rs.getInt("user_level"),
						rs.getInt("user_exp")
					);
					UpdateUser updateUserRecord = new UpdateUser(uur, result);
					updateUser = updateUserRecord;
				}
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			updateUser = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			updateUser = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					updateUser = null;
				}
			}
		}

		// 結果を返す
		return updateUser;
	}

	// ユーザーの情報を更新して、更新後のデータを取得する
	public  UpdateUser updateUser(LoginUser loginUser){
		Connection conn = null;
		UpdateUser updateUser = new UpdateUser();
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE User SET user_name=?, height=?, weight=?, bmi=?, user_level=?, user_exp=? WHERE number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, loginUser.getName());
			pStmt.setDouble(2, loginUser.getHeight());
			pStmt.setDouble(3, loginUser.getWeight());
			pStmt.setDouble(4, loginUser.getBmi());
			pStmt.setDouble(5, loginUser.getUserLevel());
			pStmt.setDouble(6, loginUser.getUserExp());
			pStmt.setInt(7, loginUser.getNumber());

			// SQL文を実行する（→成功なら更新されたデータを取得する）
			if (pStmt.executeUpdate() == 1) {
				result = true;
				// SQL文を準備する
				String sql2 = "SELECT * FROM User WHERE user_number=?";
				PreparedStatement pStmt2 =conn.prepareStatement(sql2);
				pStmt.setInt(1, loginUser.getNumber());
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt2.executeQuery();
				// 結果表をコレクションにコピーする
				while(rs.next()) {
					User uur = new User(
						rs.getInt("number"),
						rs.getString("id"),
						rs.getString("password"),
						rs.getString("user_name"),
						rs.getDouble("height"),
						rs.getDouble("weight"),
						rs.getDouble("bmi"),
						rs.getInt("user_level"),
						rs.getInt("user_exp")
					);
					UpdateUser updateUserRecord = new UpdateUser(uur, result);
					updateUser = updateUserRecord;
				}
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			updateUser = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			updateUser = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					updateUser = null;
				}
			}
		}

		// 結果を返す
		return updateUser;
	}

}
