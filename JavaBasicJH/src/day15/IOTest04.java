package day15;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest04 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("data/file_out.txt"); // 출력할 장소 지정 
			fos.write(97);
			fos.write('b');
			fos.write(99);
			fos.write('가');
			System.out.println("파일에 내용 출력 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
