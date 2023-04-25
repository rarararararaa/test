package kr.s02.statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;//sql에서 불러오면 행단위로 되어있는데 resultset으로 접근 
import java.sql.SQLException;

public class SelectMain {
	
	public static void main(String[] args) {
		String db_driver = "oracle.jdbc.OracleDriver";
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "c##user001";
		String db_password = "1234";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//1단계 : 드라이버 로드
			Class.forName(db_driver);
			//2단계 : connection 
			conn = DriverManager.getConnection(db_url, db_id, db_password);
			sql = "SELECT * FROM test1";
			//3단계 : statement
			stmt = conn.createStatement();
			//4단계 : sql를 문장을 실행해서 테이믈로부터 레코드(행)을 전달받아 결과집합을 만들고 resultset 객체에 담아 반환
			rs = stmt.executeQuery(sql);
			System.out.println("ID\t나이");
			//resultset에 보관된 결과집합에 접근해서 행단위로 데이터를 추출
			while(rs.next()) {
				//컬럼명을 이용해서 데이터를 반환
				/*ystem.out.print(rs.getString("id") + "\t");
				System.out.println(rs.getInt("age")); */
				
				//컬럼 인덱스를 통해서 데이터를 반환
				System.out.print(rs.getString(1)+"\t");
				System.out.println(rs.getInt(2));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//자원정리
			if(rs != null) {
				try {rs.close();} catch(SQLException e) {}
			}
			if(stmt != null) {
				try {stmt.close();} catch (SQLException e) {}
			}
			if(conn != null) {
				try {conn.close();} catch (SQLException e) {}
			}
		}
		
	}
	
}
