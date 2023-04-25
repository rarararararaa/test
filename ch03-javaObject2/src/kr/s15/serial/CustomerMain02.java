package kr.s15.serial;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class CustomerMain02 {
	public static void main(String[] args) {
		System.out.println("===역직렬화하기===");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("object.ser");
			ois = new ObjectInputStream(fis);
			//역직렬화 수행
			Customer m = (Customer)ois.readObject();
			
			System.out.println(m);//객체 복원
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(ois != null)try {ois.close();} catch(IOException e) {}
			if(fis != null)try {fis.close();} catch(IOException e) {}
		}
	}
}