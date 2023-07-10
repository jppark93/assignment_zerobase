package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import assignment.pbwifi;
import assignment.insertData;
import assignment.bookmarkListVar;
import assignment.bookmarkVar;
import assignment.history;
import java.util.*;

public class getData {
	 static String url = "jdbc:mysql://localhost/testdb1";
	 static String username = "testuser1";
	 static String password = "zerobase";
	 public static List<pbwifi> getD1() {
	        // MySQL 연결 정보
	       
	
	        List<pbwifi> wifiList = new ArrayList<>();

	        try {
	            // MySQL 드라이버 로드
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);

	            String selectSql = "SELECT * FROM wifi_info";
	        

	            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
	
	            ResultSet resultSet = selectStmt.executeQuery();

	            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
	            while (resultSet.next()) {
	                pbwifi wifi = new pbwifi();
	                wifi.setMgrNo(resultSet.getString("SWIFI_MGR_NO"));
	                wifi.setWrdofc(resultSet.getString("SWIFI_WRDOFC"));
	                wifi.setMainNM(resultSet.getString("SWIFI_MAIN_NM"));
	                wifi.setAddress1(resultSet.getString("SWIFI_ADRES1"));
	                wifi.setAddress2(resultSet.getString("SWIFI_ADRES2"));
	                wifi.setFloor(resultSet.getString("SWIFI_INSTL_FLOOR"));
	                wifi.setTy(resultSet.getString("SWIFI_INSTL_TY"));
	                wifi.setMby(resultSet.getString("SWIFI_INSTL_MBY"));
	                wifi.setSVC(resultSet.getString("SWIFI_SVC_SE"));
	                wifi.setCMCWR(resultSet.getString("SWIFI_CMCWR"));
	                wifi.setYear(resultSet.getString("SWIFI_CNSTC_YEAR"));
	                wifi.setInOut(resultSet.getString("SWIFI_INOUT_DOOR"));
	                wifi.setRemars(resultSet.getString("SWIFI_REMARS3"));
	                wifi.setLat(String.valueOf(resultSet.getDouble("LAT")));
	                wifi.setLnt(String.valueOf(resultSet.getDouble("LNT")));
	                wifi.setDttm(resultSet.getString("WORK_DTTM"));

	                wifiList.add(wifi);
	            }

	            // 자원 해제
	            selectStmt.close();
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        // wifiList 반환
	        return wifiList;
	    }
	public static List<pbwifi> getD(String lat, String lnt) {
        // MySQL 연결 정보
       
		Double dLat = Double.parseDouble(lat);
		Double dLnt = Double.parseDouble(lnt);
        List<pbwifi> wifiList = new ArrayList<>();

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, username, password);

            //String selectSql = "SELECT * FROM wifi_info";
            String selectSql = "SELECT *, " +
                    "(6371 * acos(cos(radians(?)) * cos(radians(LAT)) * cos(radians(LNT) - radians(?)) + " +
                    "sin(radians(?)) * sin(radians(LAT)))) AS distance " +
                    "FROM wifi_info " +
                    "ORDER BY distance " +
                    "LIMIT 20";

            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setDouble(1, dLat);
            selectStmt.setDouble(2, dLnt);
            selectStmt.setDouble(3, dLat);
            ResultSet resultSet = selectStmt.executeQuery();

            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
            while (resultSet.next()) {
                pbwifi wifi = new pbwifi();
                wifi.setMgrNo(resultSet.getString("SWIFI_MGR_NO"));
                wifi.setWrdofc(resultSet.getString("SWIFI_WRDOFC"));
                wifi.setMainNM(resultSet.getString("SWIFI_MAIN_NM"));
                wifi.setAddress1(resultSet.getString("SWIFI_ADRES1"));
                wifi.setAddress2(resultSet.getString("SWIFI_ADRES2"));
                wifi.setFloor(resultSet.getString("SWIFI_INSTL_FLOOR"));
                wifi.setTy(resultSet.getString("SWIFI_INSTL_TY"));
                wifi.setMby(resultSet.getString("SWIFI_INSTL_MBY"));
                wifi.setSVC(resultSet.getString("SWIFI_SVC_SE"));
                wifi.setCMCWR(resultSet.getString("SWIFI_CMCWR"));
                wifi.setYear(resultSet.getString("SWIFI_CNSTC_YEAR"));
                wifi.setInOut(resultSet.getString("SWIFI_INOUT_DOOR"));
                wifi.setRemars(resultSet.getString("SWIFI_REMARS3"));
                wifi.setLat(String.valueOf(resultSet.getDouble("LAT")));
                wifi.setLnt(String.valueOf(resultSet.getDouble("LNT")));
                wifi.setDttm(resultSet.getString("WORK_DTTM"));

                wifiList.add(wifi);
            }

            // 자원 해제
            selectStmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // wifiList 반환
        return wifiList;
    }
	public static List<pbwifi> getOData(String a) {
        // MySQL 연결 정보
  

        List<pbwifi> wifiList = new ArrayList<>();

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, username, password);

            String selectSql = "SELECT * FROM wifi_info WHERE SWIFI_MGR_NO =?";
            String mgrNo = a; 
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setString(1, mgrNo);
            ResultSet resultSet = selectStmt.executeQuery();

            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
            while (resultSet.next()) {
                pbwifi wifi = new pbwifi();
                wifi.setMgrNo(resultSet.getString("SWIFI_MGR_NO"));
                wifi.setWrdofc(resultSet.getString("SWIFI_WRDOFC"));
                wifi.setMainNM(resultSet.getString("SWIFI_MAIN_NM"));
                wifi.setAddress1(resultSet.getString("SWIFI_ADRES1"));
                wifi.setAddress2(resultSet.getString("SWIFI_ADRES2"));
                wifi.setFloor(resultSet.getString("SWIFI_INSTL_FLOOR"));
                wifi.setTy(resultSet.getString("SWIFI_INSTL_TY"));
                wifi.setMby(resultSet.getString("SWIFI_INSTL_MBY"));
                wifi.setSVC(resultSet.getString("SWIFI_SVC_SE"));
                wifi.setCMCWR(resultSet.getString("SWIFI_CMCWR"));
                wifi.setYear(resultSet.getString("SWIFI_CNSTC_YEAR"));
                wifi.setInOut(resultSet.getString("SWIFI_INOUT_DOOR"));
                wifi.setRemars(resultSet.getString("SWIFI_REMARS3"));
                wifi.setLat(resultSet.getString("LAT"));
                wifi.setLnt(resultSet.getString("LNT"));
                wifi.setDttm(resultSet.getString("WORK_DTTM"));

                wifiList.add(wifi);
            }

            // 자원 해제
            selectStmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // wifiList 반환
        return wifiList;
    }
	
	public static List<bookmarkVar> getBookmark() {
        // MySQL 연결 정보
   

        List<bookmarkVar> bList = new ArrayList<>();

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, username, password);

            String selectSql = "SELECT * FROM create_book_mark";
            
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
 
            ResultSet resultSet = selectStmt.executeQuery();

            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
            while (resultSet.next()) {
            	bookmarkVar bInfo = new bookmarkVar();
            	bInfo.setId(String.valueOf(resultSet.getInt("id")));
            	bInfo.setOrderNum(String.valueOf(resultSet.getInt("orderNum")));
            	bInfo.setBookmarkName(resultSet.getString("cbookmark_name"));
            	bInfo.setDate(String.valueOf(resultSet.getString("regTime")));
            	bInfo.setUpdateDate(String.valueOf(resultSet.getString("updateTime")));

                bList.add(bInfo);
            }

            // 자원 해제
            selectStmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return bList;
    }
	
	public static List<bookmarkVar> getBookmarkBynum(String id) {
        // MySQL 연결 정보
   

        List<bookmarkVar> bList = new ArrayList<>();

        try {
        	int oNum = Integer.parseInt(id);
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, username, password);

            String selectSql = "SELECT * FROM create_book_mark WHERE id =?";
            
            
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, oNum);
            ResultSet resultSet = selectStmt.executeQuery();

            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
            while (resultSet.next()) {
            	bookmarkVar bInfo = new bookmarkVar();
            	bInfo.setId(String.valueOf(resultSet.getInt("id")));
            	bInfo.setOrderNum(String.valueOf(resultSet.getInt("orderNum")));
            	bInfo.setBookmarkName(resultSet.getString("cbookmark_name"));
            	bInfo.setDate(String.valueOf(resultSet.getString("regTime")));
            	bInfo.setUpdateDate(String.valueOf(resultSet.getString("updateTime")));

                bList.add(bInfo);
            }

            // 자원 해제
            selectStmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return bList;
    }
	
	public static List<bookmarkListVar> getBookmarkList() {
        // MySQL 연결 정보
		
		
        List<bookmarkListVar> bList = new ArrayList<>();

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, username, password);

            String selectSql = "SELECT * FROM book_mark_list";
            
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
 
            ResultSet resultSet = selectStmt.executeQuery();

            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
            while (resultSet.next()) {
            	bookmarkListVar bInfo = new bookmarkListVar();
            	bInfo.setNum(String.valueOf(resultSet.getInt("num")));
            	bInfo.setId(String.valueOf(resultSet.getInt("id")));
            	bInfo.setBookmarkName(resultSet.getString("bookmark_name"));
            	bInfo.setWifiName(String.valueOf(resultSet.getString("wifi_name")));
            	bInfo.setDate(String.valueOf(resultSet.getString("updateTime")));

                bList.add(bInfo);
            }

            // 자원 해제
            selectStmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return bList;
    }
	public static List<bookmarkListVar> getBookmarkList2(String num) {
        // MySQL 연결 정보
     
		int pNum = Integer.parseInt(num);

        List<bookmarkListVar> bList = new ArrayList<>();

        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            Connection conn = DriverManager.getConnection(url, username, password);

            String selectSql = "SELECT * FROM book_mark_list WHERE num =?";
            
            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
            selectStmt.setInt(1, pNum);
            ResultSet resultSet = selectStmt.executeQuery();

            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
            while (resultSet.next()) {
            	bookmarkListVar bInfo = new bookmarkListVar();
        
            	bInfo.setBookmarkName(resultSet.getString("bookmark_name"));
            	bInfo.setWifiName(String.valueOf(resultSet.getString("wifi_name")));
            	bInfo.setDate(String.valueOf(resultSet.getString("updateTime")));

                bList.add(bInfo);
            }

            // 자원 해제
            selectStmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

      
        return bList;
    }
	
	 public static List<history> getHistory() {
	        // MySQL 연결 정보
	       
	
	        List<history> hList = new ArrayList<>();

	        try {
	            // MySQL 드라이버 로드
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);

	            String selectSql = "SELECT * FROM history_info";
	        

	            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
	
	            ResultSet resultSet = selectStmt.executeQuery();

	            // 조회 결과를 반복하면서 데이터를 추출하여 자료구조에 저장
	            while (resultSet.next()) {
	                history h = new history();
	                
	                h.setHid(resultSet.getString("id"));
	                h.setLat(resultSet.getString("history_LAT"));
	                h.setLnt(resultSet.getString("history_LNT"));
	                h.setDate(resultSet.getString("history_DTTM"));

	                hList.add(h);
	            }

	            // 자원 해제
	            selectStmt.close();
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        // wifiList 반환
	        return hList;
	    }
	
	
	public static double getDistance(double x, double y, double x1, double y1) {
			// Math.pow() <- 제곱
			// Math.sqrt() <- 루트
			double d;
			double xd, yd;
			yd = (double) Math.pow((y1-y),2);
			xd = (double) Math.pow((x1-x),2);
			d = Math.sqrt(yd+xd);
			return d;
		}
}
