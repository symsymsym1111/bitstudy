package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest01 {

	public static void main(String[] args) {
		insert("기획3");
		insert("기획4");
		insert("기획5");
		insert("기획6");
	}
	
	private static boolean insert(String deptName) {
		boolean result = false;
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2. 연결하기
			String url = "jdbc:mariadb://192.168.0.155:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			//3. Statement 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			String sql = 
				" insert" + 
				"   into dept" +
				" values (null, '" + deptName + "')"; // string+연산자를 사용하면 복잡해질수록 에러가 날 확률이 높아진다. 자바와 sql이 한곳에서 쓰이고 있기 때문.
			
			int count = stmt.executeUpdate(sql);
			
			//5. 결과 처리
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			//6. 자원 정리
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}