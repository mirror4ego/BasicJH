package day16;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest06 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("data/Test.avi");
			fos = new FileOutputStream("data/Test01.avi");
			bis = new BufferedInputStream(fis); // fis에 대해 속도를 개선하고 싶다
			bos = new BufferedOutputStream(fos); // fos에 대해 속도를 개선하고 싶다
			long sTime = System.currentTimeMillis();

			while (true) {
				int ch = bis.read();
				if (ch == -1)
					break;
				bos.write(ch);
			}
			bos.flush();
			double time = (System.currentTimeMillis() - sTime) / 1000d;
			System.out.println("복사에 걸린 시간 : " + time);
			System.out.println("버퍼를 이용한 복사 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			try {
//				bos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
