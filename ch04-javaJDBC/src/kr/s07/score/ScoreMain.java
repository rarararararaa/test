package kr.s07.score;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.io.IOException;

public class ScoreMain {
	private BufferedReader br;
	private ScoreDAO dao;
	public ScoreMain() {
		try {
			dao = new ScoreDAO();
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(br != null)try {br.close();}catch(IOException e) {}
		}
	}
	//메뉴
	public void callMenu() throws IOException, ClassNotFoundException, SQLException{
		while(true) {
			System.out.print("1.입력 2.목록 3.상세정보 4.수정 5.삭제 6.종료 >>");
			try {
				int no = Integer.parseInt(br.readLine());
				if(no == 1) {//입력
					System.out.print("이름: "); 
					String name = br.readLine();
					int korean = parseInputData("국어: ");
					int english = parseInputData("수학: ");
					int math = parseInputData("영어: ");
					int sum = korean + math + english;
					int avg = sum /3;
					String grade = getGrade(avg);
					dao.insertInfo(name, korean, english, math, sum, avg, grade);	
				}else if(no == 2) {//목록
					dao.selectInfo();
				}else if(no == 3) {//상세정보
					dao.selectInfo();
					System.out.print("검색할 번호를 입력: ");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailInfo(num);
				}else if(no == 4) {//수정
					dao.selectInfo();
					System.out.println("수정할 번호를 입력: ");
					int num = Integer.parseInt(br.readLine());
					dao.selectDetailInfo(num);
					System.out.print("이름: "); 
					String name = br.readLine();
					int korean = parseInputData("국어: ");
					int english = parseInputData("수학: ");
					int math = parseInputData("영어: ");
					int sum = korean + math + english;
					int avg = sum /3;
					String grade = getGrade(avg);
					dao.UpdateInfo(name, korean, english, math, num, sum, avg, grade);
				}else if(no == 5) {//삭제
					dao.selectInfo();
					System.out.print("삭제할 번호를 입력: ");
					int num = Integer.parseInt(br.readLine());
					dao.deleteInfo(num);
				}else if(no == 6) {//종료
					System.out.println("프로그램 종료");
					break;
				}else
					System.out.println("잘못 입력했습니다.");
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능!!");
			}
		}
	}
	//성적 범위 체크(0~100)
	public int parseInputData(String course) throws IOException{
		while(true) {
			System.out.print(course);
			try {
				int num = Integer.parseInt(br.readLine());
				if(num < 0 || num >100)
					throw new ScoreValueException("0부터 100사이의 값만 인점!");
				return num;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력하세요!");
			} catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public String getGrade(int score) {
		switch(score/10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";	
		}
	}
	
	public static void main(String[] args) {
		new ScoreMain();
	}
}
