package day15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest02 {
	public static void main (String [] args) {
		File f = new File("data/aa/fsd");
		
		// 파일 경로 관련 API
		String path = f.getPath(); // 전체경로
		String parent = f.getParent(); // 현재위치 위의까지의 경로
		String name = f.getName(); // 현재 위치의 파일이나 디렉토리명
		System.out.println("path : "+ path);
		System.out.println("parent : "+ parent);
		System.out.println("name : "+ name);
		
		boolean result = f.isFile(); // 존재하는 파일인지 아닌지
		System.out.println(result ? "파일" : "파일 아님");
		
		result = f.isDirectory(); // 존재하는 디렉토리인지 아닌지
		System.out.println(result ? "디렉토리" : "디렉토리 아님");
		
		long size = f.length(); // 파일의 크기 : byte 반환
		System.out.println(size + " bytes");
		
		long modTime = f.lastModified();  // 마지막 수정 시간
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(modTime)));
		
		System.out.println("읽기가능 : " + f.canRead());	// 읽기 가능한지 체크
		System.out.println("쓰기가능 : "+ f.canWrite());	// 쓰기 가능한지 체크
	}
}
