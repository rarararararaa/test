package kr.s02.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteMain {
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
			//2단계 : connection 객체 생성 oracle 연결
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			sql = "DELETE FROM test1 WHERE id = 'star'";
			//3단계 : statement 객체 생성
			stmt = conn.createStatement();
			//4단계 : sql문 실행
			int count = stmt.executeUpdate(sql);
			System.out.println(count+"개의 행이 삭제되었습니다.");
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
