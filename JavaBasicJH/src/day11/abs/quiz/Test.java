package day11.abs.quiz;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		
		Shape s = null;
		int command = r.nextInt(4) + 1;
		switch (command) {
		case 1:
			s = new Square(r.nextInt(10)+1);
			break; // 정사각형
		case 2:
			s = new Rectangle(r.nextInt(10)+1, r.nextInt(10)+1);
			break; // 직사각형
		case 3:
			s = new Triagle(r.nextInt(10)+1, r.nextInt(10)+1);
			break; // 삼각형
		case 4:
			s = new Circle(r.nextInt(10)+1);
			break; // 원
		}
		s.area();
	}
}
