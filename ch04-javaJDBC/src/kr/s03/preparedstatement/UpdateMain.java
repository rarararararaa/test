package kr.s03.preparedstatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.util.DBUtil;

public class UpdateMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("번호 : ");
			int num = Integer.parseInt(br.readLine());
			System.out.print("제목 : ");
			String title = br.readLine();
			System.out.print("이름 : ");
			String name = br.readLine();
			System.out.print("메모 : ");
			String memo = br.readLine();
			System.out.print("이메일 : ");
			String email = br.readLine();
			System.out.println("-------------------------------");
			//1&2단계
			conn = DBUtil.getConnection();
			System.out.println("test2 테이블의 데이터를 수정합니다.");
			//sql문 작성
			sql = "UPDATE test2 SET title = ?, name = ?, memo = ?, email = ? WHERE num = ?";
			//3단계
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, memo);
			pstmt.setString(4, email);
			pstmt.setInt(5, num);
			//4단계
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 행을 수정했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(br != null)try {br.close();} catch(IOException e) {}
			DBUtil.executeClose(null, pstmt, conn);
		}
		
	}
}
