package kr.s24.interfacetest;

//인터페이스
interface A1{
	//상수
	public static final int W = 10;
	//public static final 생략
	int X = 20;
	//public final 생략
	static int Y = 30;
	//public static 생략
	final int Z = 40;
}

public class InterMain01 {
	public static void main(String[] args) {
		//인터페이스는 객체 생성 불가능
		//A1 ap = new A1();
		//인터페이스에 정의된 상수 호출
		System.out.println("W = " + A1.W);
		System.out.println("X = " + A1.X);
		System.out.println("Y = " + A1.Y);
		System.out.println("Z = " + A1.Z);
	}
}




