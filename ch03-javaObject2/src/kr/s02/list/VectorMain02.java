package kr.s02.list;

import java.util.Vector;

public class VectorMain02 {
	public static void main(String[] args) {
		Vector<Double> v = new Vector<Double>();
		//Vector에 객체 저장
		v.add(100.3);
		v.add(3.14);
		v.add(1000.);//=1000.0
		
		//확장for문을 이용한 요소의 출력
		for(Double n : v) {
			System.out.println(n);
		}
		System.out.println("----------");
		
		//자원 검색
		double search = 1000.0;//검색할 요소
		int index = v.indexOf(search);//검색 요소가 없으면 -1반환
		if(index != -1) {//Vector에 검색 요소 저장
			System.out.println("검색 요소 : " + search	+ "의 위치 : " + index);
		}else {//Vector에 검색 요소 미저장
			System.out.println("검색 요소 : " + search	+ "가 없습니다.");
		}
		
		//자원 삭제
		double del = 3.14;//삭제할 요소
		//삭제할 요소가 Vector의 요소인지 검사
		if(v.contains(del)) {//해당 요소가 포함되어 있는지 확인
			v.remove(del);//요소의 삭제
			System.out.println(del + " 삭제 완료!");
		}
		
	}
}



