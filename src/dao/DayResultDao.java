package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DayResultDao {
	//？　引数paramで検索項目を指定し、検索結果のリストを返す
	public List</*Bc*/> select(/*Bc card*/){
		Connection conn = null;
		List</*Bc*/> /*cardList*/ = new ArrayList</*Bc*/>();
		
	}
	 
	try {
		//JDBCドライバを読み込む
		Class.forName("org.h2.Driver");
		
		//データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/D3", "sa", "");
		
		//SQL文を準備する
		String sql = "SELECT * FROM D3 WHERE date LIKE ?"
				+"AND goal_kcal LIKE ?"
				+ "AND result_kcal LIKE ?"
				+ "AND judge LIKE ?"
				+ "AND number LIKE ?";

		
	}

}
