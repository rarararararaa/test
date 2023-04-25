package kr.s17.network;
import java.net.MalformedURLException;
import java.net.URL;

public class URLMain {
	public static void main(String[] args) {
		try {
			
			URL url = new URL("http://java.sun.com/index.jsp?name=kim#content");//malform~예외가 발생할 수 있음
			System.out.println("프로토콜 : "+url.getProtocol());
			System.out.println("호스트 : "+url.getHost());
			System.out.println("기본 포트 : "+url.getDefaultPort());
			System.out.println("포트 : "+url.getPort());//명시한 포트를 반환
			System.out.println("Path : "+url.getPath());//포트 밑 하위 주소
			System.out.println("뭐리 : "+url.getQuery());
			System.out.println("ref : "+url.getRef());	
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}