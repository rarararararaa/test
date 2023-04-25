package kr.s02.list;

import java.util.ArrayList;

public class ArrayListMain03 {
	public static void main(String[] args) {
		//제네릭 표현 : 객체를 생성할 때 객체에 저장
		//           할 수 있는 요소의 타입을 지정
		ArrayList<String> list = 
				     new ArrayList<String>();
		list.add("강호동");//String
		list.add("유재석");
		//list.add(1000);
		list.add("박문수");
		
		
		//반복문을 이용한 요소의 출력
		for(int i=0;i<list.size();i++) {
			String name = list.get(i);
			System.out.println(name);
		}
		System.out.println("-----------");
		
		//확장for문을 이용한 요소의 출력
		for(String name : list) {
			System.out.println(name);
		}
		
	}
}







