package assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deleteData {
	static String url = "jdbc:mysql://localhost/testdb1";
	static String username = "testuser1";
	static String password = "zerobase";
	public static void deleteBookmarkListById(String num) {
	    // MySQL 연결 정보
	   

	    try {
	        int pid = Integer.parseInt(num);
	    	// MySQL 드라이버 로드
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 데이터베이스 연결
	        Connection conn = DriverManager.getConnection(url, username, password);

	        String deleteSql = "DELETE FROM book_mark_list WHERE num = ?";

	        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
	        deleteStmt.setInt(1, pid);

	        // 쿼리 실행
	        int rowsDeleted = deleteStmt.executeUpdate();

	        if (rowsDeleted > 0) {
	            System.out.println("데이터 삭제 성공");
	        } else {
	            System.out.println("해당 id에 해당하는 데이터가 없습니다.");
	        }

	        // 자원 해제
	        deleteStmt.close();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public static void deleteBookmarkGroup(String orderNum) {
	    // MySQL 연결 정보
	   

	    try {
	        int pid = Integer.parseInt(orderNum);
	    	// MySQL 드라이버 로드
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 데이터베이스 연결
	        Connection conn = DriverManager.getConnection(url, username, password);

	        String deleteSql = "DELETE FROM create_book_mark WHERE orderNum = ?";

	        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
	        deleteStmt.setInt(1, pid);

	        // 쿼리 실행
	        int rowsDeleted = deleteStmt.executeUpdate();

	        if (rowsDeleted > 0) {
	            System.out.println("데이터 삭제 성공");
	        } else {
	            System.out.println("해당 id에 해당하는 데이터가 없습니다.");
	        }

	        // 자원 해제
	        deleteStmt.close();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void deleteHistory(String id) {
	    // MySQL 연결 정보
	   

	    try {
	        int pid = Integer.parseInt(id);
	    	// MySQL 드라이버 로드
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 데이터베이스 연결
	        Connection conn = DriverManager.getConnection(url, username, password);

	        String deleteSql = "DELETE FROM history_info WHERE id = ?";

	        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
	        deleteStmt.setInt(1, pid);

	        // 쿼리 실행
	        int rowsDeleted = deleteStmt.executeUpdate();

	        if (rowsDeleted > 0) {
	            System.out.println("데이터 삭제 성공");
	        } else {
	            System.out.println("해당 id에 해당하는 데이터가 없습니다.");
	        }

	        // 자원 해제
	        deleteStmt.close();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
