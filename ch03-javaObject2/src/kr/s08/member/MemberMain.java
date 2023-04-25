package kr.s08.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberMain {
	ArrayList<Member> list;
	BufferedReader br;
	public MemberMain() {
		list = new ArrayList<Member>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			MakeInfo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null)try {br.close();}catch(IOException e){
			}
		}
	}
	public void MakeInfo()throws IOException{
		while(true) {
			try {
				System.out.println("1.회원정보입력 2.회원정보출력 3.종료 4.수정 5.삭제 6.위치 검색: ");
				int num = Integer.parseInt(br.readLine());
				if(num ==1) {
					register();
				}else if(num ==2) {
					showInfo();
				}else if(num ==3) {
					System.out.println("프로그램 종료");
					break;
				}
				else if(num == 4) {
					reWrite();
				}
				else if(num == 5) {
					delete();
				}
				else if(num == 6) {
					search();
				}
				else {
					System.out.print("숫자를 잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요!)");
			}
		}	
	}
	
	public void register() throws IOException{
		Member m = new Member();
		System.out.print("이름: ");
		m.setName(br.readLine());
		System.out.print("나이: ");
		int a = Integer.parseInt(br.readLine());
		if(a > 0) {
			m.setAge(a);
		}else {
			System.out.println("1살 이상 입력!");
			return;
		}
		System.out.print("직업 입력: ");
		m.setJob(br.readLine());
		System.out.print("주소 입력: ");
		m.setAddress(br.readLine());
		System.out.print("전화번호 입력: ");
		m.setPhone(br.readLine());
		
		list.add(m);	
	}
	public void showInfo() {
		System.out.println("총 인원("+list.size()+")");
		System.out.println("이름\t나이\t직업\t주소\t전화번호");
		System.out.println("--------------------------------------");
		for(Member m : list) {
			System.out.printf("%s\t",m.getName());
			System.out.printf("%d\t",m.getAge());
			System.out.printf("%s\t",m.getJob());
			System.out.printf("%s\t",m.getAddress());
			System.out.printf("%s%n",m.getPhone());
		}
		System.out.println("--------------------------------------");
	}
	public void reWrite() throws IOException{
		System.out.println("수정할 정보의 번호 입력(0부터 시작)");
		int re = Integer.parseInt(br.readLine());
		System.out.print("이름(0)\t나이(1)\t직업(2)\t주소(3)\t전화번호(4)");
		int re2 = Integer.parseInt(br.readLine());
		
		if(re2 ==0) {
			System.out.print("수정>>");
			list.get(re).setName(br.readLine());
		}else if(re2 == 1) {
			System.out.print("수정>>");
			int age = Integer.parseInt(br.readLine());
			if(age > 0) {
				list.get(re).setAge(age);
			}else {
				System.out.println("1살 이상 입력!");
			}
		}
		else if(re2 == 2) {
			System.out.print("수정>>");
			list.get(re).setJob(br.readLine());
		}
		else if(re2 == 3) {
			System.out.print("수정>>");
			list.get(re).setAddress(br.readLine());
		}
		else if(re2 == 4) {
			System.out.print("수정>>");
			list.get(re).setPhone(br.readLine());
		}
		else
			System.out.println("잘못 입력");
	}
	public void delete() throws IOException{
		System.out.print("삭제할 정보의 번호를 입력해 주세요>>");
		int del = Integer.parseInt(br.readLine());
		list.remove(del);
	}
	public void search() throws IOException{
		System.out.print("검색할 이름을 입력하세요>>");
		Scanner scan = new Scanner(System.in);
		
		int searchN = list.indexOf(br.readLine());//이거 왜 검색 안되냐
		System.out.println("검색한 번호 : "+searchN);
	}
	
	/*
	 * [실습]
	 * ArrayList에 Member객체를 저장하는 방식으로 회원 정보를 관리
	 * 메뉴: 1.회원정보입력 2.회원정보출력 3.종료
	 * ※ 조건체크 : 회원정보를 입력 받을 떄 나이는 1살이상 입력 가능
	 */
	public static void main(String[] args) {
		new MemberMain();
	}
}
