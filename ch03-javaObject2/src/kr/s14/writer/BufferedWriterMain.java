package kr.s14.writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterMain {
	public static void main(String[] args) {
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			//덮어쓰기(파일명만 명시)
			fw = new FileWriter("bufferedWriter.txt");
			bw = new BufferedWriter(fw);
			//데이터를 buffer에 저장
			bw.write("BufferedWriter 테스트 입니다");
			bw.newLine();//줄바꿈
			bw.write("안녕하세요"+System.getProperty("line.separator")+"하하하 호호호");//os에 맞게 줄바꿈
			bw.flush();//buffer를 비우고 buffer에 저장된 데이터를 파일에 저장
			
			System.out.println("파일을 생성하고 파일에 데이터를 기술함");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bw != null)try {bw.close();} catch(IOException e) {}
			if(fw != null)try {fw.close();} catch(IOException e) {}
		}
		
		
		
	}
}
