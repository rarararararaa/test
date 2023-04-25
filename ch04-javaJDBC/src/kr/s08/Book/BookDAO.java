package kr.s08.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.util.DBUtil;
//순서) 도서등록 > 도서목록 > 회원가입 > 회원목록 > 도서대출 > 대출목록 > MY대출목록 > 도서대출반납
public class BookDAO {
	//도서 등록
	public void insertBook(String name, String category) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO book (bk_num, bk_name, bk_category) VALUES (book_seq.nextval, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, category);
			
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 도서가 등록되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//도서 목록보기
	public void selectBook() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		System.out.println("============================================");
		System.out.println("도서번호\t도서명\t\t분류\t대여확인\t대여현황\t등록일");
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT  b.bk_num, bk_name, bk_category, NVL2(re_status,'대출중','대여가능') status, bk_regdate \r\n"
					+ "FROM book b LEFT OUTER JOIN (SELECT * FROM reservation WHERE re_status=1)r ON b.bk_num=r.bk_num";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("bk_num")+"\t");
				System.out.print(rs.getString("bk_name")+"\t\t");
				System.out.print(rs.getString("bk_category")+"\t");
				System.out.print(rs.getString("status")+"\t");
				System.out.println(rs.getDate("bk_regdate"));
			}
			System.out.println("============================================");

		} 
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//아이디 중복 체크
	public int checkId(String me_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT me_id FROM member WHERE me_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;//id 중복이면 1, 미중복일시 0
	}
	//회원 가입
	public void insertMember(String id, String passwd, String name, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO member (me_num, me_id, me_passwd, me_name, me_phone) VALUES (member_seq.nextval, ?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			int count = pstmt.executeUpdate();
			System.out.println(count+"명의 회원이 등록되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
		
	}
	//로그인 체크
	public int loginCheck(String me_id, String me_passwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int me_num = 0; //회원번호
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT me_num FROM member WHERE me_id = ? AND me_passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, me_id);
			pstmt.setString(2, me_passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				me_num = rs.getInt("me_num");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return me_num;
	}
	
	//회원 목록 보기
	public void selectMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		System.out.println("============================================");
		System.out.println("회원번호\tid\t비밀번호\t이름\t핸드폰번호\t등록일");
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT * FROM member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("me_num")+"\t"); 
				System.out.print(rs.getString("me_id")+"\t");
				System.out.print(rs.getString("me_passwd")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getString("me_phone")+"\t");
				System.out.println(rs.getDate("me_regdate"));
			}
			System.out.println("============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//도서 대출 여부 확인
	public int reservCheck(int bk_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		int num = 0;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_status FROM reservation WHERE bk_num = ? AND re_status = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bk_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt("re_status");
			}
				return num;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return num;
	}
	//도서 대출 등록--하는중~~~~~~~~~~~~~~~~~~~
	public void insertReservation(int bk_num, int me_num ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn = DBUtil.getConnection();
			sql = "INSERT INTO reservation (re_num, re_status, bk_num, me_num)"
					+ "VALUES (reservation_seq.nextval,1, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bk_num);
			pstmt.setInt(2, me_num);
			int count = pstmt.executeUpdate();
			System.out.println(count+"개의 도서가 대여완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//대출 목록 보기
	public void selectReservation() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		System.out.println("============================================");
		System.out.println("번호\t대출현황\t도서명\t회원이름\t대출날짜\t\t반납날짜");
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_num, DECODE(re_status,0,'반납',1,'대출중') status, bk_name, me_name, re_regdate, re_modifydate FROM reservation r, book b, member m WHERE r.bk_num = b.bk_num AND r.me_num = m.me_num ORDER BY re_modifydate DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("re_num")+"\t");
				System.out.print(rs.getString("status")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				System.out.print(rs.getString("me_name")+"\t");
				System.out.print(rs.getDate("re_regdate")+"\t");
				System.out.println(rs.getDate("re_modifydate"));	
			}
			System.out.println("============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//MY 대출 목록 보기
	public void selectMyReservation(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		System.out.println("============================================");
		System.out.println("번호\t대출현황\t도서명\t대출날짜\t\t반납날짜");
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT r.bk_num, DECODE(re_status,0,'반납',1,'대출중') status, bk_name, re_regdate, re_modifydate FROM reservation r, book b WHERE r.bk_num = b.bk_num AND me_num = ? AND re_status = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("bk_num")+"\t");
				System.out.print(rs.getString("status")+"\t");
				System.out.print(rs.getString("bk_name")+"\t");
				System.out.print(rs.getDate("re_regdate")+"\t ");
				System.out.println(rs.getDate("re_modifydate"));	
			}
			
			System.out.println("============================================");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
	}
	//반납 가능 여부 확인
	public boolean statusBook(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int check = 0;
		int me = 0;
		boolean result = false;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT re_status, me_num FROM reservation WHERE me_num = ? AND re_status = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = rs.getInt("re_status");
				me = rs.getInt("me_num");
			}
			if(check > 0) {
				selectMyReservation(me);
				result = true;
			}
			else 
				System.out.println("대여한 도서가 없습니다.");	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return result;
	}
	//반납 처리
	public void returnBook(int num, int me_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			conn =DBUtil.getConnection();
			sql = "UPDATE reservation SET re_status = 0, re_modifydate = SYSDATE WHERE bk_num = ? AND me_num = ? AND re_status = 1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, me_num);
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("대여한 도서가 아닙니다!");
				return;
			}
			System.out.println(count+"개의 도서가 반납되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(null, pstmt, conn);
		}
	}
	//도서 확인
	public int bookCheck(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			sql = "SELECT bk_num FROM book WHERE bk_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = 1;				
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.executeClose(rs, pstmt, conn);
		}
		return count;
	}
	
}
