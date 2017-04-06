package day15;

import java.io.FileReader;

public class IOTest03 {
	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("data/file.txt");
			while (true) {
				int ch = fr.read();
				if (ch == -1) { // 값이 없으면 -1을 반환하므로 그때 빠져나와야함
					break;
				}
				System.out.print((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
