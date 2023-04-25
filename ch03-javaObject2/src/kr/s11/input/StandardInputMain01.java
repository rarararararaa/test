package kr.s11.input;
import java.io.IOException;

public class StandardInputMain01 {
	
	public static void main(String[] args) {
		//자바의 기본 입력
		try {
			System.out.print("영문자 한 개 입력");
			//문자 하나를 입력 받아서 아스키코드로 반환
			int a = System.in.read();//System.in > 표준 입력
			System.out.println( a + ","+(char)a);
			
			System.in.read();//\r (=13)
			System.in.read();//\n (=10)
			
			System.out.println("------------------------");
			System.out.print("숫자 한 개 입력");
			int b = System.in.read()-48; //> 입력한 숫자를 문자로 인식해서 아스키 코드로 반환하기 때문에 숫자로 인식하기 위해서는 -48를 해줘야 한다.
			System.out.println(b);
		} catch (IOException e) {
			e.printStackTrace();//예외 문구 출력
		}
	}
}