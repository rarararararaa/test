package kr.s02.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class InsertMain {
	
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "c##user001";
		String db_password = "1234";
	
		Connection conn = null;
		Statement stmt = null;
		String sql = null;
		
		try {
			//1단계 : 드라이버 로드
			Class.forName(db_driver);
			//2단계 : connection 객체 생성해서 oracle 접속
			conn = DriverManager.getConnection(db_url,db_id,db_password);
			//sql문 작성
			sql = "INSERT INTO test1 (id, age) VALUES ('dragon',20)";
			//3단계 : statement 객체 생성
			stmt = conn.createStatement();
			//4단계 : sql문장을 실행해서 하나의 행을 삽입 삽입작업 후 삽입한 행의 개수를 반환
			int count = stmt.executeUpdate(sql);
			System.out.println(count+"개의 행을 추가했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {stmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
	}
}
