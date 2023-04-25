package kr.s02.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMain {
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "c##user001";
		String db_password = "1234";
		
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			//1단계
			Class.forName(db_driver);
			//2단계
			conn = DriverManager.getConnection(db_url, db_id,db_password);
			
			sql = "UPDATE test1 SET age = 90 WHERE id = 'star'";
			//3단계 : statement 객체 생성
			stmt = conn.createStatement();
			//4단계 : SQL문 실행 : update문을 실행하소 테이블의 행을 수정하고 수정한 행의 개수를 반환
			int count = stmt.executeUpdate(sql);
			System.out.println(count+"개의 행을 수정했습니다.");
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//자원 정리
			if(stmt != null) {
				try {stmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
		
	}
}
