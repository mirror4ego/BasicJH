package day15;

import java.io.FileInputStream;

public class IOTest02 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("data/file.txt");
			while (true) {
				int ch = fis.read(); //
				if (ch == -1) { // 값이 없으면 -1을 반환하므로 그때 빠져나와야함
					break;
				}
				System.out.print((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
