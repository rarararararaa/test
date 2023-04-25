package kr.s01.exception;

public class ExceptionMain07 {
	
	public void methodA(String[] n)throws Exception{
		if(n.length > 0) {//데이터 입력
			for(String s : n) {
				System.out.println(s);
			}
		}else {//데이터 미입력
			throw new Exception(
					"입력한 데이터가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain07 ex = 
				new ExceptionMain07();
		try {
			ex.methodA(args);
		}catch(Exception e) {
			//System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
	}
}



