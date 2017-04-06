package day12;

public class ExceptionTest05 {
	public static void main(String[] args) {
		try {
		int [] arr = {};
		arr[0] = 1;
		System.out.println(1 / 0);
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();			
		} catch (RuntimeException re){
			System.out.println(re.getMessage());
		}
	}
}
