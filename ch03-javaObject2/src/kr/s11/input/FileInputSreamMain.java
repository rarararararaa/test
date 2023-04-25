package kr.s11.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputSreamMain {
	public static void main(String[] args) {
		FileInputStream fis = null;
		int readbyte;
		byte [] readbyte2; //한글 처리
		
		try {
			fis = new FileInputStream("file.txt");
			
			//파일로부커 데이터를 읽어오기 위해 FileInputStream 객체를 생성
			/*while((readbyte=fis.read())!= -1) {//파일의 정보를 한 문자씩 읽어들여 아스키 코드로 반환 > 1byte 처리(한글은 꺠짐)
				System.out.print((char)readbyte);//영문이외의 문자는 깨짐
			}*/
			
			
			//영문이외의 문자도 처리 가능
			readbyte2 = new byte[fis.available()];//available 읽어오려는 데이터를 바이트로 환산
			fis.read(readbyte2);//파일로부터 읽어들인 데이터를 byte[]에 저장
									//byte [] -> String 변환
			System.out.println(new String(readbyte2));
			
		} catch (FileNotFoundException e) {//부모
			e.printStackTrace();
			// TODO: handle exception
		} catch(IOException e) {//자식
			e.printStackTrace();
		} finally {//자원정리
			if(fis != null)try {fis.close();}catch(IOException e) {};
		}
	}
}