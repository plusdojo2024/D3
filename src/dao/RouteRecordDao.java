package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RouteRecord;

public class RouteRecordDao {
    public List<RouteRecord> select(RouteRecord card) {
        Connection conn =null;
        List<RouteRecord> cardList = new ArrayList<RouteRecord>();

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D3", "sa", "");

            // SQL文を準備する
            String sql = "SELECT * FROM RouteRecord WHERE route_number, start_ido, start_keido, end_ido, end_keido, distance, move_kind, kcal, registDate, number, spot";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            // SQL文を完成させる
            if (card.getroute_number() != null) {
                pStmt.setInt(1, "%" + card.route_number() + "%");
            }
            else {
                pStmt.setInt(1, "%");
            }
            if (card.getstart_ido() != null) {
            pStmt.setDouble(2, "%" + card.getstart_ido() + "%");
            }
            else {
            pStmt.setDouble(2, "%");
            }

            if (card.getstart_keido() != null) {
            pStmt.setDouble(3, "%" + card.getstart_keido() + "%");
            }
            else {
            pStmt.setDouble(3, "%");
            }
            if (card.getend_ido() != null) {
            pStmt.setDouble(4, "%" + card.getend_ido() + "%");
            }
            else {
            pStmt.setDouble(4, "%");
            }

            if (card.getend_keido() != null) {
            pStmt.setDouble(5, "%" + card.getend_keido() + "%");
            }
            else {
            pStmt.setDouble(5, "%");
            }
            if (card.getdistance() != null) {
            pStmt.setDouble(6, "%" + card.getdistance() + "%");
            }
            else {
            pStmt.setDouble(6, "%");
            }

            if (card.getmove_kind() != null) {
            pStmt.setInt(7, "%" + card.getmove_kind() + "%");
            }
            else {
            pStmt.setInt(7, "%");
            }
            if (card.getkcal() != null) {
            pStmt.setDouble(8, "%" + card.getkcal() + "%");
            }
            else {
            pStmt.setDouble(8, "%");
            }

            if (card.getregist_date() != null) {
            pStmt.setDate(9, "%" + card.getregist_date() + "%");
            }
            else {
            pStmt.setDate(9, "%");
            }
            if (card.getnumber() != null) {
            pStmt.setInt(10, "%" + card.getnumber() + "%");
            }
            else {
            pStmt.setInt(10, "%");
            }

            if (card.getspot() != null) {
            pStmt.setVarchar(11, "%" + card.getspot() + "%");
            }
            else {
            pStmt.setVarchar(11, "%");
            }
            // SQL文を実行し、結果表を取得する
            ResultSet rs = pStmt.executeQuery();

            // 結果表をコレクションにコピーする
            while (rs.next()) {
                RouteRecord record = new RouteRecord(
                rs.getInt("route_number"),
                rs.getDouble("start_ido"),
                rs.getDouble("start_keido"),
                rs.getDouble("end_ido"),
                rs.getDouble("end_keido"),
                rs.getDouble("distance"),
                rs.getInt("mov_kind"),
                rs.getDouble("kcal"),
                rs.getDate("regist_date"),
                rs.getInt("number"),
                rs.getString("spot"),
                );
                cardList.add(record);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            cardList = null;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            cardList = null;
        }
        finally {
            if(conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    cardList = null;
                }
            }
        }

        return cardList;

    public boolean insert(RouteRecord card) {
        Connection conn = null;
        boolean result = false;

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D3", "sa", "");

            String sql = "INSERT INTO RouteRecord VALUES NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);

			if (card.getroute_number() != null && !card.getroute_number().equals("")) {
				pStmt.setInt(1, card.getroute_number());
			}
			else {
				pStmt.setInt(1, "（未設定）");
			}
			if (card.getstart_ido() != null && !card.getstart_ido().equals("")) {
				pStmt.setDouble(2, card.getstart_ido());
			}
			else {
				pStmt.setDouble(2, "（未設定）");
			}

			if (card.getstart_keido() != null && !card.getstart_keido().equals("")) {
				pStmt.setDouble(3, card.getstart_keido());
			}
			else {
				pStmt.setDouble(3, "（未設定）");
			}
			if (card.getend_ido() != null && !card.getend_ido().equals("")) {
				pStmt.setDouble(4, card.getend_ido());
			}
			else {
				pStmt.setDouble(4, "（未設定）");
			}

			if (card.getend_keido() != null && !card.getend_keido().equals("")) {
				pStmt.setDouble(5, card.getend_keido());
			}
			else {
				pStmt.setDouble(5, "（未設定）");
			}
			if (card.getdistance() != null && !card.getdistance().equals("")) {
				pStmt.setDouble(6, card.getdistance());
			}
			else {
				pStmt.setDouble(6, "（未設定）");
			}

			if (card.getmove_kind() != null && !card.getmove_kind().equals("")) {
				pStmt.setInt(7, card.getmove_kind());
			}
			else {
				pStmt.setInt(7, "（未設定）");
			}
			if (card.getkcal() != null && !card.getkcal().equals("")) {
				pStmt.setDouble(8, card.getkcal());
			}
			else {
				pStmt.setDouble(8, "（未設定）");
			}

			if (card.getregist_date() != null && !card.getregist_date().equals("")) {
				pStmt.setDate(9, card.getregist_date());
			}
			else {
				pStmt.setDate(9, "（未設定）");
			}
			if (card.getnumber() != null && !card.getnumber().equals("")) {
				pStmt.setInt(10, card.getnumber());
			}
			else {
				pStmt.setInt(10, "（未設定）");
			}

			if (card.getspot() != null && !card.getspot().equals("")) {
				pStmt.setVarchar(11, card.getspot());
			}
			else {
				pStmt.setVarchar(11, "（未設定）");
			}

        }
    }


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
			String sql = "DELETE FROM RouteRecord WHERE route_number=?";
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

    
	public List<RouteRecord> collect(int y, int m, int d) {
		Connection conn = null;
		List<RouteRecord> RouteRecordList = new ArrayList<>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM Record WHERE regist_date = ? ";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			pStmt.setString(1, "%");

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
	        //java.util.Date date2 = new java.util.Date(date1.getTime());
			
			while (rs.next()) {
				RouteRecord routeRecord = new RouteRecord(
					rs.getInt("route_number"),
					rs.getDouble("start_ido"),
					rs.getDouble("start_keido"),
					rs.getDouble("end_ido"),
					rs.getDouble("end_keido"),
					rs.getDouble("distance"),
					rs.getInt("move_kind"),
					rs.getDouble("kcal"),
					new java.util.Date(rs.getDate("regist_date").getTime()),
					rs.getInt("number"),
					rs.getString("spot"));
				RouteRecordList.add(routeRecord);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			RouteRecordList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			RouteRecordList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					RouteRecordList = null;
				}
			}
		}

		// 結果を返す
		return RouteRecordList;
		

	}	

    
}