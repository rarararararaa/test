package kr.s17.network;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlMain02 {
	
	public static void main(String[] args) {
		String address = "https://www.naver.com/index.html";
		BufferedReader input = null;
		String line;
		try {
			URL url = new URL(address);
			input = new BufferedReader(new InputStreamReader(url.openStream()));//네트워크에서 입력받음
																//URL에 저장된 인터넷 주소를 이용해서 서버에 HIML 데이터를 InputStream 타입으로 반환
			while((line = input.readLine())!= null) {
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(input != null)try {input.close();} catch(IOException e) {}
		}
	}
}