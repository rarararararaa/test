package kr.s03.preparedstatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;
public class SelectDetailMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호 : ");
			int num = Integer.parseInt(br.readLine());
			//1&2단계
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM test2 WHERE num = ?";
			//3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			//4단계 : sql문 실행 -> resultset에 담아서 반환
			rs = pstmt.executeQuery();
			if(rs.next()){//단일행일시 while보단 if를 사용
				System.out.println("번호 : "+rs.getInt("num"));
				System.out.println("제목 : "+rs.getString("title"));
				System.out.println("작성자 : "+rs.getString("name"));
				System.out.println("내용 : "+rs.getString("memo"));
				System.out.println("이메일 : "+rs.getString("email"));
				System.out.println("작성일 : "+rs.getDate("reg_date"));
				
			}else {
				System.out.println("검색된 데이터가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//자원정리
			if(br != null)try {br.close();} catch(IOException e) {}
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
}