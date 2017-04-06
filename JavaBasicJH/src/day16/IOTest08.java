/*
 *	기본형 값의 쓰기와 읽기
 *	DataInputStream, DataOutputStream 
 */
package day16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOTest08 {
	private static void writeData() throws Exception {
		FileOutputStream fos = new FileOutputStream("data/b.txt");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(9832472); 	// 4
		dos.writeChar('가'); 	// 2
		dos.writeDouble(1.1); 	// 8
		dos.writeUTF("가나다라마");
		dos.close();
		fos.close();
	}

	private static void readData() throws Exception { 
		FileInputStream fis = new FileInputStream("data/b.txt");
		DataInputStream dis = new DataInputStream(fis);
		// 쓴 순서대로 읽어야 함
		int i = dis.readInt();
		char c = dis.readChar();
		double d = dis.readDouble();
		String s = dis.readUTF();
		
		System.out.println(i);
		System.out.println(c);
		System.out.println(d);
		System.out.println(s);
		dis.close();
		fis.close();
	}

	public static void main(String[] args) throws Exception {
		writeData();
		readData();
		System.out.println("테스트 완료");
	}
}