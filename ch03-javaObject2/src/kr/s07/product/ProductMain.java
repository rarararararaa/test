package kr.s07.product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ProductMain {//휘발성 데이터
	ArrayList<Product> list;
	BufferedReader br;
	//생성자
	public ProductMain() {
		list = new ArrayList<Product>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e){
			}
		}
	}
	public void callMenu() throws IOException{
		while(true) {
			try {
				System.out.print("<1. 상품 입력 2. 상품 목록보기 3. 종료>");
				int num = Integer.parseInt(br.readLine()); //readLint()[무조건 String으로 반환하기 떄문에 Integer변환] >OException 발생 가능성O
				if(num ==1) {
					Product p = new Product();
					System.out.print("상품명: ");
					p.setName(br.readLine());
					System.out.print("상품번호: ");
					p.setNum(br.readLine());
					System.out.print("가격: ");
					p.setPrice(Integer.parseInt(br.readLine()));
					System.out.print("제조사: ");
					p.setMaker(br.readLine());
					System.out.print("재고: ");
					p.setStock(Integer.parseInt(br.readLine()));
					
					//ArrayList에 Product를 저장
					list.add(p);
				}else if(num ==2) {//상품목록보기 
					System.out.println("상품리스트: 총 상품수("+list.size()+")");
					System.out.println("상품명\t상품번호\t가격\t제조사\t재고수");
					System.out.println("---------------------------------");
					for(Product p : list ) {
						System.out.printf("%s\t",p.getName());
						System.out.printf("%s\t",p.getNum());
						System.out.printf("%,d원\t",p.getPrice());
						System.out.printf("%s\t",p.getMaker());
						System.out.printf("%,d%n",p.getStock());
					}						
				}else if(num ==3) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("잘못 입력했습니다.");
				}
			} catch (NumberFormatException e) { //parsInt() > NumberFormatException
				System.out.println("숫자만 입력!");
			}
		}
	}
	
	public static void main(String[] args) {
		new ProductMain();
	}
}
