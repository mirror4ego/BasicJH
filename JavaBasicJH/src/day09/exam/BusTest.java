package day09.exam;

/*
 * 실행시 출력결과가 아래와 같이 나오도록 Bus 클래스를 작성하시오
 * 
 * 출력결과 >
 * 
 	360번 버스 운행시작.
	승객 3명 승차.
	승객 1명 하차.
	승객 1명 승차.
	승객 2명 하차.
	승객 5명 승차.
	승객 3명 하차.
	360번 버스의 현재 승차인원: 3명.
	모든 버스의 누적 승차인원: 9명.
	740번 버스 운행시작.
	승객 2명 승차.
	승객 1명 하차.
	승객 3명 승차.
	승객 2명 하차.
	승객 2명 승차.
	승객 3명 하차.
	740번 버스의 현재 승차인원: 1명.
	모든 버스의 누적 승차인원: 16명.
 */

class Bus {
	int busNum;
	int count;
	static int countSum;
	
	
	public Bus (int busNum) {
		System.out.printf("%d번버스 운행시작\n", busNum);
		this.busNum = busNum;
	}

	
	void ride(int num) {
		System.out.printf("승객 %d명 승차.\n",num);
		count += num;
		countSum += num;				
	}

	void leave(int num) {
		System.out.printf("승객 %d명 하차.\n", num);
		count -= num;
	}
	
	public String toString(){
		return busNum+"번 버스의 현재 승차인원 : "+count+"명.\n"+"모든 버스의 누적 승차인원 : "+countSum+"명.";
	}
}


public class BusTest {
	public static void main(String[] args) {
		Bus no360 = new Bus(360); 
		no360.ride(3);
		no360.leave(1);
		no360.ride(1);
		no360.leave(2);
		no360.ride(5);
		no360.leave(3);
		System.out.println(no360); 
		                   
		

		Bus no740 = new Bus(740);
		no740.ride(2);
		no740.leave(1);
		no740.ride(3);
		no740.leave(2);
		no740.ride(2);
		no740.leave(3);
		System.out.println(no740);
		
	}
}
