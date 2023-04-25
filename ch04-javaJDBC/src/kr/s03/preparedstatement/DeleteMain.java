package kr.s03.preparedstatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import kr.util.DBUtil;
//삭제하거나 오류가 발생하면 시퀀스 번호가 건너뛸수도 있다.
public class DeleteMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호");
			int num = Integer.parseInt(br.readLine());
			//1&2단계
			conn = DBUtil.getConnection();
			System.out.println("test2 테이블의 데이터를 삭제합니다.");
			
			//sql문 작성
			sql = "DELETE FROM test2 WHERE num = ?";
			//3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 행을 삭제했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//자원 정리
			DBUtil.executeClose(null, pstmt, conn);
			if(br != null)try {br.close();} catch(IOException e) {}
		}
	}
}
