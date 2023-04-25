package kr.s07.score;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.util.DBUtil;

public class ScoreDAO {
	ArrayList<ScoreDAO> list = new ArrayList<ScoreDAO>();
	//성적입력
	public void insertInfo(String name, int korean, int english, int math, int sum, int avg, String grade) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO score VALUES(SCORE_SEQ.nextval, ?,?,?,?,?,?,?, SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, korean);
			pstmt.setInt(3, english);
			pstmt.setInt(4, math);
			pstmt.setInt(5, sum);
			pstmt.setInt(6, avg);
			pstmt.setString(7, grade);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 행이 추가되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//목록보기
	public void selectInfo() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT num, name, korean, english, math, sum, avg, grade FROM score";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("----------------------------------------------------------------");
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
			while(rs.next()) {
				
				System.out.println(toString(rs.getInt("num"),
									rs.getString("name"),
									rs.getInt("korean"),
									rs.getInt("english"),
									rs.getInt("math"),
									rs.getInt("sum"),
									rs.getInt("avg"),
									rs.getString("grade")
						));	
			}
			System.out.println("----------------------------------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		
	}
	//성적수정
	public void UpdateInfo(String name, int korean, int english, int math, int num, int sum, int avg, String grade) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		conn = DBUtil.getConnection();
		sql = "UPDATE score SET name = ?, korean = ?, english = ?, math = ?, sum = ?, avg = ?, grade = ? WHERE num = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, korean);
		pstmt.setInt(3, english);
		pstmt.setInt(4, math);
		pstmt.setInt(5, sum);
		pstmt.setInt(6, avg);
		pstmt.setString(7, grade);
		pstmt.setInt(8, num);
		int count = pstmt.executeUpdate();
		System.out.println(count+"개의 행이 수정되었습니다.");
	}
	//성적삭제
	public void deleteInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "DELETE FROM score WHERE num = ?";
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
	//성적상세정보
	public void selectDetailInfo(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM score WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				System.out.println("번호: "+rs.getInt("num"));
				System.out.println("이름: "+rs.getString("name"));
				System.out.println("국어: "+rs.getInt("korean"));
				System.out.println("영어: "+rs.getInt("english"));
				System.out.println("수학: "+rs.getInt("math"));
				System.out.println("총점: "+rs.getInt("sum"));
				System.out.println("평균: "+rs.getInt("avg"));
				System.out.println("등급: "+rs.getString("grade"));
				System.out.println("날짜: "+rs.getDate("reg_date"));
				
				rs.getDate("reg_date");
			}else {
				System.out.println("검색한 데이터가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	public String toString(int num, String name, int korean, int english, int math, int sum, int avg, String grade) {
		return String.format("%d\t%s\t%d\t%d\t%d\t%d\t%d\t%s",
				num, name, korean, english, math, sum, avg, grade );
	}
	public String toString(int id, String name, int korean, int english, int math, int sum, int avg, String grade, Date reg_date) {
		return String.format("번호: %d\n이름: %s\n국어: %d\n영어: %d\n수학: %d\n총점: %d\n평균: %d\n등급: %s\t날짜: %9$tY년 %9$tB월",
				id, name, korean, english, math, sum, avg, grade, reg_date);
	}
}
