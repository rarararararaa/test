package kr.s13.reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;//bufferedreader & inputstreamreader
import java.io.IOException;

public class BufferedReaderMain01 {//범용적으로 많이 사용
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
											//InputStreamReader는 System.in(바이트 입력 스트림)를 문자 입력 스트림으로 변환 
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("당신의 이름: ");
			String name = br.readLine();//readLine()은 IOException 필수
			
			System.out.println(name);
			System.out.print("당신의 나이: ");
			int age = Integer.parseInt(br.readLine());
						//String -> int로 변환
			System.out.println(age);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {//의무
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {	}
		}
		
	}

}
