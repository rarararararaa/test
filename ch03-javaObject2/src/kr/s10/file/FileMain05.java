package kr.s10.file;
import java.io.File;
public class FileMain05 {

	public static void main(String[] args) {
		String path = "C:\\JavaWork\\javaSample";//javaSample 디렉터리 생성 > 절대경로 지정
		
		System.out.println("===디렉터리 생성===");
		//디렉터리를 생성한 후 true 반환, 생성할 수 없으면 false
		File f1 = new File(path);
		
		System.out.println(f1.mkdir());
		
		System.out.println("===디렉터리 삭제===");
		if(f1.delete()) {//디렉터리를 삭제할 수 있으면 삭제 후 true / 삭제할 수 없으면 false
			System.out.println(f1.getName()+"디렉터리 삭제");
		}else
			System.out.println("디렉터리를 삭제할 수 없습니다.");
	}
}
