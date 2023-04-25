package kr.s16.trainning;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class MemberMain {
	ArrayList<Member> list;
	BufferedReader br;
	public MemberMain() {
		list = new ArrayList<Member>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			makeInfo();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br != null)try {br.close();} catch(IOException e) {}
		}
	}
	public void makeInfo() throws IOException{
		while(true) {
			try {
				System.out.print("메뉴 : 1.회원 정보 입력 | 2. 회원 정보 출력 | 3. 파일 생성 | 4. 파일 읽기 | 5. 종료 : ");
				int input = Integer.parseInt(br.readLine());
				if(input == 1) {
					inputData();
				}else if(input == 2) {
					showInfo();
				}else if(input == 3) {
					mF(list);
					//makeFile();
				}else if(input == 4) {
					rF();
					//readFile();
				}else if(input == 5) {
					System.out.println("프로그램 종료...");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			}
		}
	}
	public void inputData() throws IOException {
				Member m = new Member();
				System.out.print("이름: "); m.setName(br.readLine());
				while(true) {
					try {
						System.out.print("나이: ");
						int a = Integer.parseInt(br.readLine());
						if(a>0) {
							m.setAge(a);
							break;
						}
						System.out.println("1살 이상 입력!");
					} catch (NumberFormatException e) {
						System.out.println("숫자만 입력 가능!!");
					}
				}
				System.out.print("직업: "); m.setJob(br.readLine());
				System.out.print("주소: "); m.setAddress(br.readLine());
				System.out.print("핸드폰: "); m.setPhone(br.readLine());
				System.out.print("취미: "); m.setHobby(br.readLine());
				list.add(m);//멤버 저장
	}
	
	public void showInfo() {
		System.out.println("이름\t나이\t직업\t주소\t핸드폰\t취미");
		System.out.println("----------------------------------------------------------");

		for(Member m : list) {
			System.out.println(m.toString());
		}
		System.out.println("----------------------------------------------------------");
	}
	
	public void makeFile() throws IOException{
		FileWriter fr = null;
		try {
			fr = new FileWriter("Member.txt");
			fr.write("----------------------------------------------------------\n");
			fr.write("이름\t나이\t직업\t주소\t핸드폰\t취미\n");
			fr.write("----------------------------------------------------------\n");
			for(Member m : list) {//toString 재정의
				fr.write(m.toString());//★★★★★★★★★★★★★★
			}
			fr.flush();
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(fr != null) try {fr.close();} catch(IOException e) {}
		}
	}
	public void readFile() throws IOException{
		FileReader fr = null;
		try {
			fr = new FileReader("Member.txt");
			int rebyte;
			while((rebyte = fr.read())!= -1) {
				System.out.print((char)rebyte);
			}
			System.out.println();
		}catch(FileNotFoundException e) {
			System.out.println("생성된 파일이 없습니다.");
		}
		finally {
			if(fr != null)try {fr.close();} catch(IOException e) {}
		}
	}
	public void mF(ArrayList<Member> list) {
		FileOutputStream fo = null;
		ObjectOutputStream of = null;
		
		try {
			fo = new FileOutputStream("Member_1.ser");
			of = new ObjectOutputStream(fo);
			of.writeObject(list);
			
			System.out.println("파일 생성 완료!!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(of != null)try {of.close();} catch(IOException e) {}
			if(fo != null)try {fo.close();} catch (IOException e) {}
		}
	}
	public void rF() throws IOException {
		FileInputStream iif = null;
		ObjectInputStream op = null;
		try {
			iif = new FileInputStream("Member_1.ser");
			op = new ObjectInputStream(iif);	
			ArrayList<Member> list = (ArrayList<Member>)op.readObject(); //list 반환
			System.out.println(list);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {	
			if(op != null)try {op.close();} catch(IOException e) {}
			if(iif != null)try {op.close();} catch(IOException e) {}
		}	
	}
	/*
	 * [실습]
	 * ArrayList에 Member객체를 저장
	 * 메뉴 : 1.회원 정보 입력 | 2. 회원 정보 출력 | 3. 파일 생성 | 4. 파일 읽기 | 5. 종료 :
	 * 조건 체크 : 나이는 1살이상 입력 가능 
	 */
	public static void main(String[] args) {
	new MemberMain();
	}
}