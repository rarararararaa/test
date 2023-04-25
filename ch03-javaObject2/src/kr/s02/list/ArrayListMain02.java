package kr.s02.list;

import java.util.ArrayList;

public class ArrayListMain02 {
	public static void main(String[] args) {
		//List 구조의 특징 : 저장되는 순서를 유지,
		//                중복 저장 허용
		ArrayList list = new ArrayList();
		list.add("홍길동");//0 String->Object
		list.add("박문수");//1 String->Object
		list.add("장영실");//2 String->Object
		list.add("홍길동");//3 String->Object
		//일반적으로 타입을 맞춰서 사용
		//ArrayList에 저장된 요소의 목록
		System.out.println(list);
		System.out.println("---------");
		
		//반복문을 이용한 요소 출력
		for(int i=0;i<list.size();i++) {
			              //Object->String
			String name = (String)list.get(i);
			System.out.println(name);
		}
	}
}



