// 반환타입 연습
// 만약, 반환타입이 void가 아니라면 반드시 메서드내에 return 값; 이 있어야 한다.
// return 문의 의미
// 1. 메서드를 종료시킨다.
// 2. 메서드를 호출한 곳으로 값을 넘겨준다.
package day07;



import java.util.Random;


public class MethodSub02 {
	int method1() {
		return 1;
	}
	
	int method2() {
		Random r = new Random();
		return r.nextInt(10)+1;
	}
	
	char method3() {
		return 'c';		
	}
	
	int method4(Random r) {
		return r.nextInt(10)+1;
	}
	
	String method5() {
		return "hello";
	}
	
	Random method6() {
		return new Random();
	}
	
	int[] method7() {
//		int [] arr = new int[3];
//		int [] arr = {1,2};
//		int [] arr = new int[]{1,2,3};
		return new int[]{1,2,3};
	}

	HaHaHa method8(HoHoHo ho) {
		HaHaHa i = new HaHaHa();
		return i;
	}
	
}

class HoHoHo {}
class HaHaHa {}