package day15;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException {
		File f = new File("data/a/b/c");
		System.out.println(f.mkdirs() ? "디렉토리 생성" : "생성 실패"); // 디렉토리 생성

		File f1 = new File("data/file.txt");
		System.out.println(f.exists());
		if (f.exists()) {// 파일의 존재여부 판단
			System.out.println(f.delete() ? "파일 삭제" : "삭제 실패"); // 파일 삭제
		} else {
			try {
				System.out.println(f.createNewFile() ? "파일 생성" : "생성 실패"); // 새로운 파일 생성
			} catch (IOException e) {
				System.out.println("파일 생성 실패");
				e.printStackTrace();
			}
		}

	}
}
