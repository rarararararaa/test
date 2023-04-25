package kr.s14.writer;
import java.io.FileWriter;
import java.io.IOException;
public class TestWrite {
	public static void main(String[] args) {
		FileWriter tw = null;
		try {
			tw = new FileWriter("TestWrite.txt");
			String message = "test 테스트 중";
			tw.write(message+System.getProperty("line.separator")+"추가입력");
			tw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(tw != null) try {tw.close();}catch(IOException e) {}
		}

	}

}
