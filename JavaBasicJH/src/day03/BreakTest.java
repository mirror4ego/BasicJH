package day03;

import java.util.Random;

public class BreakTest {
public static void main(String[] args) {
	
	Random r = new Random();
	int stopNum = r.nextInt(10) + 1;
	System.out.println("stopNum : " + stopNum);
	
/*	for (int i = 1; i < 6 ; i++) {
		System.out.println(i);
		if (i == stopNum) {
		break;
		}
	} */
	
	stopNum = 2;
	outer: for (int count = 1; count < 3; count++){
		for (int i = 1; i < 6 ; i++) {
			System.out.println(i);
			if (i == stopNum) {
				break outer;
			}
		}
	}
}
}
