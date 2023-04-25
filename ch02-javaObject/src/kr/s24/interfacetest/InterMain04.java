package kr.s24.interfacetest;

interface InterSub{
	//추상메서드
	public void make();
	public default void show() {
		System.out.println();
	}
}
class InterCenter implements InterSub{
	//인터페이스의 추상메서드를 구현
	@Override
	public void make() {
		System.out.println("make메서드");
	}
	
	public void play() {
		System.out.println("play메서드");
	}
}

public class InterMain04 {
	public static void main(String[] args) {
		InterCenter ic = new InterCenter();
		ic.make();
		ic.play();
		
		InterSub is = ic;//클래스타입->인터페이스타입 형변환
		                 //자동적으로 형변환
		is.make();
		//호출 범위를 벗어나 호출 불가
		//is.play();
		
		//인터페이스타입 -> 클래스타입 형변환
		//명시적으로 형변환
		InterCenter ic2 = (InterCenter)is;
		ic2.make();
		ic2.play();
	}
}




