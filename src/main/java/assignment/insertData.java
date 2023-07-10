package assignment;
import assignment.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import assignment.pbwifi;
import assignment.bookmarkVar;
import java.util.*;


public class insertData {
	 static String url = "jdbc:mysql://localhost/testdb1";
     static String username = "testuser1";
     static String password = "zerobase";
    
	 public static void insert(pbwifi pubwifi) {
	        // MySQL 연결 정보
	        
	       
	        try {
	            // MySQL 드라이버 로드
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);
	            
	            String checkDuplicateSql = "SELECT COUNT(*) FROM wifi_info WHERE SWIFI_MGR_NO = ?";

	            // PreparedStatement 생성
	            PreparedStatement checkDuplicateStmt = conn.prepareStatement(checkDuplicateSql);
	            checkDuplicateStmt.setString(1, pubwifi.getMgrNo().replaceAll("-", ""));

	            // 중복 데이터 확인 실행
	            ResultSet resultSet = checkDuplicateStmt.executeQuery();
	            resultSet.next();

	            int duplicateCount = resultSet.getInt(1);

	            // 중복 데이터가 이미 존재하는 경우 데이터 삽입을 하지 않고 종료
	            if (duplicateCount > 0) {
	                System.out.println("중복된 데이터가 이미 존재합니다");
	                return;
	            }
	        
	            // 데이터 삽입을 위한 SQL 문장
	            String sql = "INSERT INTO wifi_info (SWIFI_MGR_NO, SWIFI_WRDOFC, SWIFI_MAIN_NM, SWIFI_ADRES1, SWIFI_ADRES2, " +
	                    "SWIFI_INSTL_FLOOR, SWIFI_INSTL_TY, SWIFI_INSTL_MBY, SWIFI_SVC_SE, SWIFI_CMCWR, SWIFI_CNSTC_YEAR, " +
	                    "SWIFI_INOUT_DOOR, SWIFI_REMARS3, LAT, LNT, WORK_DTTM) " +
	                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            // PreparedStatement 생성
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	          
	            // 데이터 설정
	          
	            pstmt.setString(1, pubwifi.getMgrNo().replaceAll("-", ""));
	            pstmt.setString(2, pubwifi.getWrdofc());
	            pstmt.setString(3, pubwifi.getMainNM());
	            pstmt.setString(4, pubwifi.getAddress1());
	            pstmt.setString(5, pubwifi.getAddress2());
	            pstmt.setString(6, pubwifi.getFloor());
	            pstmt.setString(7, pubwifi.getTy());
	            pstmt.setString(8, pubwifi.getMby());
	            pstmt.setString(9, pubwifi.getSVC());
	            pstmt.setString(10, pubwifi.getCMCWR());
	            pstmt.setString(11, pubwifi.getYear());
	            pstmt.setString(12, pubwifi.getInOut());
	            pstmt.setString(13, pubwifi.getRemars());
	            pstmt.setDouble(14, Double.parseDouble(pubwifi.getLat()));
	            pstmt.setDouble(15, Double.parseDouble(pubwifi.getLnt()));
	            pstmt.setString(16, pubwifi.getDttm());
	           

	            // 데이터 삽입 실행
	            int rowsAffected = pstmt.executeUpdate();

	            // 결과 확인
	            if (rowsAffected > 0) {
	                System.out.println("데이터 삽입 성공");
	            } else {
	                System.out.println("데이터 삽입 실패");
	            }

	            // 자원 해제
	            pstmt.close();
	       
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 public static void historyInsert(String a) {
		 try {
	            // MySQL 드라이버 로드
			 
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            List<pbwifi> wifiList = new ArrayList<>();
	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);
	            
	            String selectSql = "SELECT * FROM wifi_info WHERE SWIFI_MGR_NO =?";
	        
	            // 데이터 삽입을 위한 SQL 문장
	            String sql = "INSERT INTO history_info (LAT, LNT, WORK_DTTM) " +
	                    "VALUES (?, ?, ?)";

	            // PreparedStatement 생성
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
	            String mgrNo = a; 
	            selectStmt.setString(1, mgrNo);
	            ResultSet resultSet = selectStmt.executeQuery();
	            
	          
	            // 데이터 
	            while (resultSet.next()) {
	                pbwifi wifi = new pbwifi();
	               
	                wifi.setLat(resultSet.getString("LAT"));
	                wifi.setLnt(resultSet.getString("LNT"));
	                wifi.setDttm(resultSet.getString("WORK_DTTM"));
	                	
	                wifiList.add(wifi);
	            }
	            
	            pstmt.setString(2, wifiList.get(0).getLat());
	            pstmt.setString(3, wifiList.get(0).getLnt());
	            pstmt.setString(4, wifiList.get(0).getDttm());

	            // 데이터 삽입 실행
	            int rowsAffected = pstmt.executeUpdate();

	            // 결과 확인
	            if (rowsAffected > 0) {
	                System.out.println("데이터 삽입 성공");
	            } else {
	                System.out.println("데이터 삽입 실패");
	            }

	            // 자원 해제
	            pstmt.close();
	       
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	 }
	 public static int bookmarkInsert(String num, String name) {
		 try {
	            // MySQL 드라이버 로드
			 
			 	int orderNum = Integer.parseInt(num);
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);
	            
	            String checkDuplicateSql = "SELECT COUNT(*) FROM create_book_mark WHERE orderNum = ?";

	            // PreparedStatement 생성
	            PreparedStatement checkDuplicateStmt = conn.prepareStatement(checkDuplicateSql);
	            checkDuplicateStmt.setInt(1, orderNum);

	            // 중복 데이터 확인 실행
	            ResultSet resultSet = checkDuplicateStmt.executeQuery();
	            resultSet.next();

	            int duplicateCount = resultSet.getInt(1);

	            // 중복 데이터가 이미 존재하는 경우 데이터 삽입을 하지 않고 종료
	            if (duplicateCount > 0) {
	                System.out.println("중복된 순서가 이미 존재합니다");
	                return -1;
	            }
	            // 데이터 삽입을 위한 SQL 문장
	            String sql = "INSERT INTO create_book_mark (orderNum, cbookmark_name) " +
	                    "VALUES (?, ?)";

	            // PreparedStatement 생성
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	            
	            pstmt.setInt(1, orderNum);
	            pstmt.setString(2, name);
	            

	            // 데이터 삽입 실행
	            int rowsAffected = pstmt.executeUpdate();

	            // 결과 확인
	            if (rowsAffected > 0) {
	                System.out.println("데이터 삽입 성공");
	            } else {
	                System.out.println("데이터 삽입 실패");
	            }

	            // 자원 해제
	            pstmt.close();
	       
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
		 return 1;
	 }
	 public static void bookmarkListInsert(String id,String name, String mgrno) {
		 try {
	            // MySQL 드라이버 로드
			 
			 	int pid = Integer.parseInt(id);
			 	String swifiMainNm="";
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);
	            
	            
	           
	            String selectSql = "SELECT * FROM wifi_info WHERE SWIFI_MGR_NO =?";
	            PreparedStatement selectStmt = conn.prepareStatement(selectSql);
	            
	            selectStmt.setString(1, mgrno);
	            ResultSet resultSet = selectStmt.executeQuery();
	            if (resultSet.next()) {
	                swifiMainNm = resultSet.getString("SWIFI_MAIN_NM");
	                // swifiMainNm 값 사용
	            }
	            // 데이터 삽입을 위한 SQL 문장
	            String sql = "INSERT INTO book_mark_list (id,bookmark_name,wifi_name) " +
	                    "VALUES (?, ?, ?)";

	            // PreparedStatement 생성
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	            
	            pstmt.setInt(1, pid);
	            pstmt.setString(2, name);
	            pstmt.setString(3, String.valueOf(swifiMainNm));

	            // 데이터 삽입 실행
	            int rowsAffected = pstmt.executeUpdate();

	            // 결과 확인
	            if (rowsAffected > 0) {
	                System.out.println("데이터 삽입 성공");
	            } else {
	                System.out.println("데이터 삽입 실패");
	            }

	            // 자원 해제
	            pstmt.close();
	       
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
		
	 }
	 
	 public static void historyInsert(String lat, String lnt) {
		 try {
	            // MySQL 드라이버 로드
			 
			 
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            // 데이터베이스 연결
	            Connection conn = DriverManager.getConnection(url, username, password);
	            
	            
	           
	    
	            // 데이터 삽입을 위한 SQL 문장
	            String sql = "INSERT INTO history_info (history_LAT,history_LNT) " +
	                    "VALUES (?, ?)";

	            // PreparedStatement 생성
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	    
	            
	           
	            pstmt.setString(1, lat);
	            pstmt.setString(2, lnt);

	            // 데이터 삽입 실행
	            int rowsAffected = pstmt.executeUpdate();

	            // 결과 확인
	            if (rowsAffected > 0) {
	                System.out.println("데이터 삽입 성공");
	            } else {
	                System.out.println("데이터 삽입 실패");
	            }

	            // 자원 해제
	            pstmt.close();
	       
	            conn.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
		
	 }
}
