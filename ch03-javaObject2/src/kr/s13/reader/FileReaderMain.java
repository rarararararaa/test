package kr.s13.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderMain {
	public static void main(String[] args) {
		FileReader fr = null;
		int readChar;
		try {
			//파일로부터 데이터를 한 문자씩 읽어들여 유니코드로 반환(2바이트로 입력 처리)
			fr = new FileReader("file.txt");
			while((readChar = fr.read()) != -1) {//Reader를 상속 받기 떄문에 read()는 2byte로 받는다.
				System.out.print((char)readChar);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			}
		catch(IOException e){
			e.printStackTrace();
		}finally {
			if(fr != null)try {fr.close();}catch(IOException e) {}
		}
	}
}
