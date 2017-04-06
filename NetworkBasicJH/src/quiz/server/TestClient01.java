package quiz.server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TestClient01 {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("192.168.0.228", 10001);
			InputStream in = client.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			System.out.println(dis.readUTF());
			dis.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
