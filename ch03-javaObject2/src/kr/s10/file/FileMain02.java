package kr.s10.file;
import java.io.File;
import java.io.IOException;
public class FileMain02 {

	public static void main(String[] args) {
		//절대 경로 지정[전체 경로 명시]
		//String path = "C:\\JavaWork\\sample.txt";//경로를 복사해서 넣으면 자동으로 // 
		
		//상대 경로 지정[일부 경로만 명시 or 파일명만 명시] > 해당 project가 기본 경로(ch03-javaObject2에 만들어짐)
		String path = "sample.txt";
		
		File f1 = new File(path);
		System.out.println("===파일 생성===");
		
		try {
			//제공된 경로를 기반으로 파일을 생성, 파일이 생성되면 true반환/ 생성되지 않으면 false반환
			//경로가 잘못되면 IOException 발생
			System.out.println(f1.createNewFile());
		} catch (IOException e) {//경로가 잘못되면 발생
			e.printStackTrace();//예외 문구 출력
		}
		System.out.println("===파일의 정보===");
		System.out.println("절대 경로 : "+f1.getAbsolutePath());
		System.out.println("상대 경로 : "+f1.getPath());
		System.out.println("디렉터리명 : "+f1.getParent());
		System.out.println("파일명 : "+f1.getName());		
	}
}
