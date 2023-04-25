package kr.s09.score;
/*
 * [실습]
 * 멤버 변수 : 이름(name), 국어(Korean), 영어(english), 수학(math)
 * 멤버 메소드 : get/set, 총점구하기(makeSum), 평균구하기(makeAvg), 등급구하기(makeGrade)
 * 
 */
public class Score {
	private String name; private int korean; private int english; private int math;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	public int makeSum() {
		return this.korean + this.english + this.math;
	}
	public double makeAvg() {
		return makeSum()/3;
	}
	public String makeGrade() {
		switch((int)makeAvg()/10) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
	public String toString() {
		return String.format("%s\t%d점\t%d점\t%d점\t%d점\t%.2f점%s%n", name,korean,english,math,makeSum(),makeAvg(),makeGrade());
				
	}
	
}