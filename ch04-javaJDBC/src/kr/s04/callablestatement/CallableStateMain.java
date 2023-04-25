package kr.s04.callablestatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;

import kr.util.DBUtil;

public class CallableStateMain {
	public static void main(String[] args) {
		BufferedReader br = null;
		Connection conn = null;
		CallableStatement cstmt = null;
		String sql = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("이름 : ");
			String name = br.readLine();
			System.out.print("인상률 : ");
			float rate = Float.parseFloat(br.readLine());//String -> Float
			//1&2단계
			conn = DBUtil.getConnection();
			
			//프로시저 호출 문장 작성
			sql = "{call adjust(?,?)}"; //ORACLE SQL에서는 exec | JAVA에서는 CALL 
			//3단계 CALLABLESTATEMENT 객체 생성
			cstmt = conn.prepareCall(sql);
			//?에 데이터 바인딩
			cstmt.setString(1, name);
			cstmt.setFloat(2, rate);
			//4단계
			int count = cstmt.executeUpdate();
			System.out.println(count+"개의 급여정보를 수정했습니다.");
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//자원정리
			DBUtil.executeClose(cstmt, conn);
			if(br != null)try {br.close();} catch(IOException e) {}
		}
	}
}
