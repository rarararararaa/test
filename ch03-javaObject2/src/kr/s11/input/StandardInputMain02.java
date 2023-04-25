package kr.s11.input;

import java.io.IOException;

public class StandardInputMain02 {
	
	public static void main(String[] args) {
		try {
			int input = 0;
			
			while((input = System.in.read())!= -1) {//-1 : 더 이상 입력할 것이 없다. > (Ctrl + z)입력
				//기본 스트림은 불편해서 잘 사용안함
				System.out.println("input: "+input+"(char)input: "+(char)input);
			}
			System.out.println("프로그램 종료");
		} catch (IOException e) {
			e.printStackTrace();//예외 문구 출력
		}
	}
}