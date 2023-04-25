package kr.s05.transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.util.DBUtil;

public class TransactionMain {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			//sql문 작성
			//트랜젝션을 수동처리하기 위해 auto commit을 해제
			conn.setAutoCommit(false);
			
			sql = "INSERT INTO test1 VALUES('Korea',500)";
			pstmt1 = conn.prepareStatement(sql);
			pstmt1.executeUpdate();
			sql = "INSERT INTO test1 VALUES('England', 400)";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.executeUpdate();
			//테스트용으로 오류가 있는 spl문 작성
			sql = "INSERT INTO test1 VALUES ('China, 300)";
			pstmt3 = conn.prepareStatement(sql);
			pstmt3.executeUpdate();
			//정상적으로 작업이 완료되면 commit
			conn.commit();
			System.out.println("작업 완료!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
			//예외가 발생했을 경우 rollback
			try {
				conn.rollback();
			} catch (SQLException es) {
				es.printStackTrace();
			}
		}finally {
			//자원정리
			DBUtil.executeClose(null, pstmt1, conn);
			DBUtil.executeClose(null, pstmt2, conn);
			DBUtil.executeClose(null, pstmt3, conn);
		}
	}
}
