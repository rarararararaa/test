package kr.s08.Book;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BookUserMain {
	private BufferedReader br;
	private BookDAO dao;
	private int me_num;//회원번호
	private boolean flag;//로그인여부 > 로그인 true
	public BookUserMain() {
		try {
			dao = new BookDAO();
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br != null)try {br.close();} catch(IOException e) {}
		}
	}
	public void callMenu() throws IOException{
		while(true) {
			System.out.print("1.로그인, 2.회원가입, 3.종료>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//로그인
					System.out.print("아이디: ");
					String me_id = br.readLine();
					System.out.print("비밀번호: ");
					String me_passwd = br.readLine();
					me_num = dao.loginCheck(me_id, me_passwd);
					if(me_num > 0) {
						System.out.println(me_id+"님 로그인 되었습니다.");
						flag = true;
						break;
					}
					System.out.println("아이디 또는 비밀번호 불일치");
				}else if(no == 2) {//회원가입
					String check = checkId("아이디");
					System.out.print("비밀번호: ");
					String passwd = br.readLine();
					System.out.print("이름: ");
					String name = br.readLine();
					System.out.print("핸드폰 번호: ");
					String phone = br.readLine();
					dao.insertMember(check, passwd, name, phone);
				}else if(no == 3) {//종료
					System.out.println("프로그램 종료");
					break;
				}else
					System.out.println("잘못 입력했습니다.");
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능!!!");
			}
		}//end of while
		while(flag) {//로그인시 메뉴
			System.out.print("1.도서대출, 2.MY대출목록, 3.대출도서 반납, 4.종료");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//도서대출
					dao.selectBook();
					System.out.print("대여하고 싶은 도서의 번호 입력: ");
					int bk_num = Integer.parseInt(br.readLine());
					int num = dao.bookCheck(bk_num);
					if(num > 0) {
						int check = dao.reservCheck(bk_num);
						if(check < 1) {
							dao.insertReservation(bk_num, me_num);
						}else
							System.out.println("대출 불가");
					}
					else
						System.out.println("없는 도서입니다.");
					
				}else if(no == 2) {//MY대출목혹
					dao.statusBook(me_num);
					//dao.selectMyReservation(me_num);
					
				}else if(no == 3) {//대출도서 반납
					if(dao.statusBook(me_num)) {
						System.out.print("반납할 도서의 번호 입력: ");
						int num = Integer.parseInt(br.readLine());
						int re_num = dao.bookCheck(num);
						if(re_num <= 0) {
							System.out.println("없는 도서입니다.");
							continue;
						}
						else
							dao.returnBook(num,me_num);
					}
					/*int check = dao.statusBook(num);
					if(check > 0) 
						dao.returnBook(num);
					else
						System.out.println("반납할 도서가 없습니다.");*/
					
					
				}else if(no == 4) {//종료
					System.out.println("프로그램 종료");
					break;
				}else
					System.out.println("잘못 입력했습니다.");
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력가능!!");
			}
		}
	}//end of callMenu
	public String checkId(String id) throws IOException{
		while(true) {
			System.out.println(id);
			String inputid = br.readLine();
			int check = dao.checkId(inputid);
			if(check == 0) 
				return inputid;
			System.out.println("중복된 아이디 입니다.");
		}
	}
	public static void main(String[] args) {
		new BookUserMain();
	}
}
