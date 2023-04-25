package kr.s13.reader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestRead {

	public static void main(String[] args) {
		FileReader fw = null;
		try {
			fw = new FileReader("TestWrite.txt");
			int readbyte;
			if((readbyte = fw.read())!= -1) {
				System.out.println((char)readbyte);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fw != null)try { fw.close();} catch(IOException e) {}
		}

	}

}
