package kr.s08.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CafeMain {
	ArrayList<Cafe> list;
	BufferedReader br;
	 public CafeMain() {
		 list = new ArrayList<Cafe>();
		 try {
			br = new BufferedReader(new InputStreamReader(System.in));
			Makecafe();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {if(br != null)try{br.close();}catch(IOException e) {}
	 }
}
	 public void Makecafe() throws IOException{
			 while(true) {
				 try {
					System.out.print("1. 메뉴 추가 | 2. 메뉴판 보기 | 3. 종료 | 4. 가격 수정: ");
					int input = Integer.parseInt(br.readLine());
					if(input ==1) {
						makeMenu();
					}else if(input == 2) {
						showMenu();
					}else if(input == 3) {
						System.out.println("프로그램 종료...");
						break;
					}else if(input == 4) {
						
					}
					else
						System.out.println("잘못된 번호 입력");
				} catch (IOException e) {
					System.out.println("입출력 오류");
				}catch(NumberFormatException e) {
					System.out.println("숫자만 입력 가능");
				}
			 }
	 }
	 public void makeMenu() throws IOException{
		 try {
			 Cafe c = new Cafe();
			 System.out.print("메뉴 이름: ");
			 c.setCoffee(br.readLine());
			 System.out.print("가격: "); int p = Integer.parseInt(br.readLine());
			 if(p <= 0) {
				 System.out.println("0보다 큰 값입력");			 
				 return; 
			 }
			 c.setPrice(p);
			 list.add(c);
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	 }
	public void showMenu() {
		System.out.println("음료\t가격");
		System.out.println("=================================="); 
		for(Cafe c : list) {
			System.out.printf("%s\t",c.getCoffee());
			System.out.printf("%,d원%n",c.getPrice());
		}
		System.out.println("=================================="); 
	}
/*	public int searchM() throws IOException{
		while(true) {
			try {
				System.out.println("수정할 메뉴: ");
				String menu = br.readLine();
				if(!list.contains(menu))
					throw new CafeMenuVauleException("메뉴판에 있는 상품을 입력");
				return list.indexOf(menu);
			}
			catch (CafeMenuVauleException e) {
				e.getStackTrace();
			}	
		}
	}*/
	
	public static void main (String[] args) {
		new CafeMain();
	}

}
