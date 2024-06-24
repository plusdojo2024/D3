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
	public List<RouteRecord> select(int number) {
        Connection conn =null;
        List<RouteRecord> cardList = new ArrayList<RouteRecord>();

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D3", "sa", "");

            // SQL文を準備する
            String sql = "SELECT * FROM Route_Record WHERE number = ? order by regist_date";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            // SQL文を完成させる
            pStmt.setInt(1, number);

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
                rs.getString("spot")
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
   }

    public boolean insert(RouteRecord card) {
        Connection conn = null;
        boolean result = false;

        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D3", "sa", "");

            String sql = "INSERT INTO Route_Record VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setDouble(1, card.getStartIdo());
            pStmt.setDouble(2, card.getStartKeido());
            pStmt.setDouble(3, card.getEndIdo());
            pStmt.setDouble(4, card.getEndKeido());
            pStmt.setDouble(5, card.getDistance());
            pStmt.setInt(6, card.getMoveKind());
            pStmt.setDouble(7, card.getKcal());
            pStmt.setDate(8, new java.sql.Date(card.getRegistDate().getTime()));
            pStmt.setInt(9, card.getNumber());
            pStmt.setString(10, card.getSpot());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

        }
        catch (SQLException e) {
            e.printStackTrace();
            result = false;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            result = false;
        }
        finally {
            if(conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    result = false;
                }
            }
        }
        return result;
    }

    public RouteRecord getRoute(int userNumber) {
    	Connection conn = null;
    	RouteRecord history = new RouteRecord();

    	try {
    		Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D3", "sa", "");

            String sql = "SELECT * FROM Route_Record WHERE userNumber = loginUser AND SELECT loginNumber = (SELECT MAX(recordNumber) FROM Route_Record)";
            PreparedStatement pStmt = conn.prepareStatement(sql);


    	}
    	catch (SQLException e) {
            e.printStackTrace();
            history = null;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            history = null;
        }
        finally {
            if(conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                    history = null;
                }
            }
        }
    	return history;
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