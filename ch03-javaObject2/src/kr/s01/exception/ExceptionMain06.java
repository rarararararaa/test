package kr.s01.exception;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionMain06 {
	
	//멤버메서드
	public void printData() throws IOException,NumberFormatException {
		/*
		 * throws 예약어의 사용
		 * 메서드에서 예외가 발생할 수 있고 예외가 발생
		 * 하면 예외를 임시 보관하기 위해서 
		 * throws 예상되는 예외클래스명 형식으로 메서드
		 * 에 표시함. 이렇게 표시하면 메서드가 호출된 곳에
		 * try~catch문을 명시하고 예외처리하게 됨
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //반드시try-catch문을 작성해야함
		System.out.print("단 입력:");
		          //String -> int
		int dan = Integer.parseInt(
				             br.readLine());
		System.out.println(dan + "단");
		System.out.println("---------");
		for(int i=1;i<=9;i++) {
			System.out.println(
					dan+"*"+i+"="+dan*i);
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain06 ex = 
				new ExceptionMain06();
		try {
			ex.printData();
		}catch(NumberFormatException e) {
			System.out.println("숫자가 아닙니다.");
		}catch(IOException e) {
			System.out.println("입력시 오류 발생");
		}
	}
}


