package kr.s03.preparedstatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;

public class SelectMain {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			//1단계 & 2단계
			conn = DBUtil.getConnection();
			
			sql = "SELECT * FROM test2 ORDER BY num DESC";
			//3단계 & 4단계
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("번호\t제목\t\t작성자\t등록일");
			while(rs.next()) {
				System.out.print(rs.getInt("num")+"\t");//
				System.out.print(rs.getString("title")+"\t\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.println(rs.getDate("reg_date"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5단계
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}

}
