package day16;

import java.io.*;

public class IOTest07 {
	public static void main(String[] args) {
		// BufferedReader, BufferedWriter
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		long sTime = System.currentTimeMillis();
		
		try {
			fr = new FileReader("data/a.txt");
			fw = new FileWriter("data/a2.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while (true) {
				int ch = br.read();
				if (ch == -1) break;
				bw.write(ch);
			}
			
			// 버퍼의 내용을 강제로 출력하기
			bw.flush();
			
			double time = (System.currentTimeMillis() - sTime) / 1000d;
			System.out.println("복사에 걸린 시간 : " + time);
			System.out.println("버퍼를 이용한 복사 성공");
			
		} catch (Exception e) {	
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			try {
//				bos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}
}
