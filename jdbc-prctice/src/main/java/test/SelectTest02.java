package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest02 {

	public static void main(String[] args) {
		list();
	}

	public static void list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mariadb://192.168.0.155:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statement 준비
			String sql = 
					"   select no, name" + 
					"     from dept" +
					" order by no desc";
			pstmt = conn.prepareStatement(sql);

			//4. Binding
			
			//5. SQL 실행
			rs = pstmt.executeQuery();
			
			//5. 결과 처리
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				System.out.println(no + ":" + name);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			//6. 자원 정리
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}