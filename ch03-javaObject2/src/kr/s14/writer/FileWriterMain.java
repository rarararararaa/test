package kr.s14.writer;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMain {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("fileWriter.txt");//덮어쓰기(파일명만)
			
			String message = "안녕하세요 FileWriter 테스트";
			fw.write(message); //데이터를 buffer에 저장
			
			//buffer를 비우고 buffer의 데이터를 파일로 전송
			fw.flush();
			System.out.println("파일을 생성하고 내용을 기술한다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null)try {fw.close();} catch(IOException e) {}
		}
		
	}
}