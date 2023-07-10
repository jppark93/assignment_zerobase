package assignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class dataModify {
	static String url = "jdbc:mysql://localhost/testdb1";
	static String username = "testuser1";
	static String password = "zerobase";
	public static int updateBookmarkGroup(String orderNum,String bName, String id) {
	    try {
	    	int oNum = Integer.parseInt(orderNum);
	    	int pid = Integer.parseInt(id);
	        // MySQL 드라이버 로드
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 데이터베이스 연결
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String checkDuplicateSql = "SELECT COUNT(*) FROM create_book_mark WHERE orderNum = ?";

            // PreparedStatement 생성
            PreparedStatement checkDuplicateStmt = conn.prepareStatement(checkDuplicateSql);
            checkDuplicateStmt.setInt(1, oNum);

            // 중복 데이터 확인 실행
            ResultSet resultSet = checkDuplicateStmt.executeQuery();
            resultSet.next();

            int duplicateCount = resultSet.getInt(1);

            // 중복 데이터가 이미 존재하는 경우 데이터 삽입을 하지 않고 종료
            if (duplicateCount > 0) {
                System.out.println("중복된 순서가 이미 존재합니다");
                return -1;
            }
	        // 데이터 수정
	        String updateSql = "UPDATE create_book_mark SET orderNum = ?, cbookmark_name = ? WHERE id = ?";
	        String updateSql2 = "UPDATE create_book_mark SET updateTime = now() WHERE id = ?";
	        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
	        PreparedStatement updateStmt2 = conn.prepareStatement(updateSql2);
	        updateStmt.setInt(1, oNum);
	        updateStmt.setString(2, bName);
	        updateStmt.setInt(3, pid);
	        
	        updateStmt2.setInt(1,pid);
	        int rowsUpdated = updateStmt.executeUpdate();
	        int rowsUpdated2 = updateStmt2.executeUpdate();

	        if (rowsUpdated > 0 && rowsUpdated2 > 0) {
	            System.out.println("데이터 수정 성공");
	        } else {
	            System.out.println("해당 orderNum에 해당하는 데이터가 없습니다.");
	        }

	        updateStmt.close();
	        conn.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 1;
	}
}
