package day06;

class IceCream {
	String name;
	int price;
}

public class ClassTest {
	public static void main(String[] args) {
		IceCream ic1 = new IceCream();	
		IceCream ic2 = new IceCream();
		IceCream ic3 = ic1;
			
		ic1.name = "홍";
		ic1.price = 100;
		ic2.name = "김";
		ic2.price = 2000;
		ic3.name = "박";
		ic3.price = 500;
		
		System.out.println(ic1.name);
		System.out.println(ic1.price);
		System.out.println(ic2.name);
		System.out.println(ic2.price);
		System.out.println(ic3.name);
		System.out.println(ic3.price);
		
		
		
	}
}
