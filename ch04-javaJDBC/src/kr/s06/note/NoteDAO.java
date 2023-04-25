package kr.s06.note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.util.DBUtil;

//Data Access Object : 전문적으로 DB 데이터에 접근하는 객체
public class NoteDAO {
			
	public void insertInfo(String name, String passwd, String subject, String content, String email) {//글쓰기
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//1&2단계
			conn = DBUtil.getConnection();
			sql = "INSERT INTO note VALUES (note_seq.nextval, ?,?,?,?,?, SYSDATE)";
			//3단계
			pstmt = conn.prepareStatement(sql);
			//?에 데이터 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			//4단계
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 행을 삽입했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//자원정리
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	public void selectInfo() throws ClassNotFoundException, SQLException {//목록보기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		//1&2
		conn = DBUtil.getConnection();
		sql = "SELECT * FROM note ORDER BY num DESC";
		//3단계 pstmt 생성
		pstmt = conn.prepareStatement(sql);
		//4단계 sql문을 실행
		rs = pstmt.executeQuery();
		
		System.out.println("----------------------------------------");
		System.out.println("글번호\t제목\t이름\t작성일");
		while(rs.next()) {
			System.out.print(rs.getInt("num")+"\t");
			System.out.print(rs.getString("subject")+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.println(rs.getDate("reg_date")+"\t");
		}
		System.out.println("----------------------------------------");
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}	
	}
	
	public void selectDetailInfo(int num) {//상세글보기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			//1,2단계 conn
			conn = DBUtil.getConnection();
			//sql작성
			sql = "SELECT * FROM note WHERE num = ?";
			//3단계 pstmt 생성
			pstmt = conn.prepareStatement(sql);
			//?에 바인딩
			pstmt.setInt(1, num);
			//4단계 sql 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("글번호: "+rs.getInt("num"));
				System.out.println("이름: "+rs.getString("name"));
				System.out.println("비밀번호: "+rs.getString("passwd"));
				System.out.println("제목: "+rs.getString("subject"));
				System.out.println("내용: "+rs.getString("content"));
				System.out.println("이메일: "+rs.getString("email"));
				System.out.println("작성일: "+rs.getDate("reg_date"));
				
			}else {
				System.out.println("검색된 정보가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
	}
	public void updateInfo(int num, String name, String passwd, String subject, String content, String email){//글수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			//1,2단계 conn 생성
			conn = DBUtil.getConnection();
			//sql문 작성
			sql = "UPDATE note SET name = ?, passwd = ?, subject = ?, content = ?, email = ? WHERE num = ?";
			//3단계 pstmt 생성
			pstmt = conn.prepareStatement(sql);
			//? 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, passwd);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setString(5, email);
			pstmt.setInt(6, num);
			//4단계 sql문 실행
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 행을 수정했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
		
	}
	public void deleteInfo(int num){//글삭제
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "DELETE FROM note WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 행이 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();		
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	
}
