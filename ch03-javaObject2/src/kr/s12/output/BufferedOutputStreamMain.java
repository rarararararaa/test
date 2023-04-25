package kr.s12.output;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferedOutputStreamMain {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			
			fos = new FileOutputStream("bufferOut.txt");
			bos = new BufferedOutputStream(fos); //연계
			String str = "BufferedOutputStream Test 입니다.";
			//생성된 파일에 데이터를 저장
			bos.write(str.getBytes());//String -> byte []
			//buffer에 데이터 저장
			bos.flush();//버퍼를 비우고 버퍼의 데이터를 파일에 출력
			System.out.println("파일을 생성하고 파일에 내용을 기술함");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {//자원정리 (생성된 객체의 역순으로)						//BufferedOutputStream 의 close()
			if(bos != null)try {bos.close();}catch(IOException e) {}//bos.close()는 자원정리(출력 종료) 뿐만아니라 buffer도 살펴봄(데이터가 누락 되지 않았는지 체크)
			if(fos != null)try {fos.close();}catch(IOException e) {}
		}
		
	}
}