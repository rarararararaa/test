package kr.s05.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetMain {
	public static void main(String[] args) {
		String[] array = 
			{"Java","JSP","Java","Oracle"};
		
		HashSet<String> hs = new HashSet<String>();
		//HashSet에 문자열 객체 저장
		for(String n : array) {
			hs.add(n);//중복 불허
		}
		//HashSet 요소의 목록
		System.out.println(hs);
		System.out.println("-----------");
		
		Iterator<String> ir = hs.iterator();
		//Iterator에 저장된 객체가 있는지 검증
		while(ir.hasNext()) {
			//검증된 객체를 반환
			System.out.println(ir.next());
		}
		System.out.println("-----------");
		//확장for문을 이용한 출력
		for(String s : hs) {
			System.out.println(s);
		}
	}
}


