package kr.s15.serial;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//객체에 저장된 데이터를 사용하고 싶을 떄 > 작업을 일시중단해도 이어서 할 수 있다.
public class SerialMain02 {//역직렬화
	public static void main(String[] args) {
		FileInputStream fis = null; //파일에 접근해서 데이터를 읽어옴
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("userInfo.ser");
			ois = new ObjectInputStream(fis);
			
			//역직렬화
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)ois.readObject(); //list 반환
			
			System.out.println(list);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(ois != null)try {ois.close();} catch(IOException e) {}
			if(fis != null)try {fis.close();} catch(IOException e) {}
			
		}
		
	}

}