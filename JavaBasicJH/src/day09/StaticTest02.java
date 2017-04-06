// 스테틱은 메모리정리 대상이 아니기 때문에 상수값이나 공통적으로 꾸준이 사용하는경우 스테틱선언을 해주면 속도가 빠르다.

package day09;

public class StaticTest02 {
//	static int i = 100;
	int i = 100;
	static int k = 100;
	
	public void print() {
		System.out.println(i);
		System.out.println(StaticTest02.k);
	}
	public static void main (String[] args){
		StaticTest02 st = new StaticTest02();
		System.out.println(st.i);
		System.out.println(st.k); // 스테틱영역은 직접 접근해야 빠르다.
	}
}
