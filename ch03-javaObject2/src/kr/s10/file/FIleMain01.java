package kr.s10.file;
import java.io.File;
public class FIleMain01 {

	public static void main(String[] args) {
		
		//경로 지정 > 역슬래시 일반 문자화 > \\
		String path = "C:\\";
		File f = new File(path);
		
		if(!f.exists() || !f.isDirectory()) {
			//C가 존재하는지 체크
			System.out.println("유효하지 않은 디렉터리 입니다.");
			System.exit(0);
		}
		//지정한 경로의 하위 디텍토리와 파일 정보를 File 배열로 전환
		File[] files = f.listFiles(); //현재 C를 저정
		
		for(int i=0;i<files.length;i++) {
			File f2 = files[i];
			if(f2.isDirectory()) {//디렉터리인 경우
				System.out.println("["+f2.getName()+"]");//디렉터리명
			}else {//파일인 경우
				System.out.println(f2.getName());//파일명
				System.out.printf("(%,dbytes)\n",f2.length());//파일의 용량
			}
		}
	}
}
