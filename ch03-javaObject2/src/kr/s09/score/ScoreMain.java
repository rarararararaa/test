package kr.s09.score;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStreamReader;


public class ScoreMain {
	ArrayList<Score> list;
	BufferedReader br;
	public ScoreMain() {
		list = new ArrayList<Score>();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			makeInfo_s();
		} catch (IOException e) {
			e.printStackTrace();
	}finally {//자원 정리
		if(br!=null)try {br.close();}catch(IOException e){
		}
	}
}
	public void makeInfo_s() throws IOException{
		try {
			while(true) {
				System.out.print("1. 성적 입력 2. 성적 출력 3. 종료: ");
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {
					inputInfo();
				}else if(num == 2) {
					showInfo();
				}else if(num == 3) {
					System.out.println("프로그램 종료");
					break;
				}else
					System.out.println("번호를 잘못 입력했습니다.");
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력하세요.");
		}
	}
	public void inputInfo() throws IOException{
		try {
			Score s = new Score();
			System.out.print("이름: ");s.setName(br.readLine());
			s.setKorean(Check("국어"));
			s.setEnglish(Check("영어"));
			s.setMath(Check("수학"));
			/*System.out.print("국어: ");int k = Integer.parseInt(br.readLine());
			if(k < 0 || k > 100) 
				throw new ScoreValueException("범위 내의 값을 입력하세요!");
			else
				 s.setKorean(k);
			System.out.print("영어: ");int e = Integer.parseInt(br.readLine());
			if(e < 0 || e > 100)
				throw new ScoreValueException("범위 내의 값을 입력하세요!");
			else
				 s.setEnglish(e);
			System.out.print("수학: ");int m = Integer.parseInt(br.readLine());
			if(m < 0 || m > 100)
				throw new ScoreValueException("범위 내의 값을 입력하세요!");
			else
				 s.setMath(m);*/
			list.add(s);
			 
		}catch(NumberFormatException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
		}
	}
	
	public void showInfo() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		for(Score s : list) {
			System.out.println(s.toString());
			System.out.println("-----------------------------------------------------");
		}
	}
	public int Check(String score) throws IOException{
		while(true) {
			System.out.println(score);
			try {
				int num = Integer.parseInt(br.readLine());
				if(num <0 || num >100) {
					throw new ScoreValueException("0~100만 인정");
				}
				return num;
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능");
			}catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	/*
	 * [실습]
	 * ArrayList에 Score를 저장하는 프로그램
	 * 메뉴: 1. 성적 입력 2. 성적 출력 3. 종료
	 * 조건 체크: 성적 유효 범위 체크(0~100의 값만 인정!!)
	 */
	public static void main(String[] args) {
		new ScoreMain();
	}
}
