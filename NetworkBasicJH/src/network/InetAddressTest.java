package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println(local); //호스트명 / 호스트주소
			System.out.println(local.getHostName()); //호스트명
			System.out.println(local.getHostAddress()); //호스트주소
			
			InetAddress bit = InetAddress.getByName("www.bitjobedu.co.kr");
			System.out.println(bit); //호스트명 / 호스트주소
			System.out.println(bit.getHostName()); //호스트명
			System.out.println(bit.getHostAddress()); //호스트주소
			
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
			for (InetAddress inet : naver){
				System.out.println(inet);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
