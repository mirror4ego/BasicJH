package day09.exam;

import java.util.Random;

public class AreaMain {
	public static void main(String[] args) {
		Random r = new Random();
		Shape s = new Shape();
		int num;
		int area = 0;
		String shape = "";
		num = r.nextInt(4)+1;
		switch (num) {
		case 1:
			Rectangle ra = new Rectangle();
			ra.area(r.nextInt(10) + 1);
			area = ra.shapeArea;
			shape = "정사각형";
			break;
			
		case 2:
			Square sq = new Square();
			sq.area(r.nextInt(10) + 1, r.nextInt(10) + 1);
			area = sq.shapeArea;
			shape = "직사각형";
			break;
			
		case 3:
			Circle cc = new Circle();
			cc.area(r.nextInt(10) + 1);
			area = cc.shapeArea;
			shape = "삼각형";
			break;
			
		case 4:
			Triangle ta = new Triangle();
			ta.area(r.nextInt(10) + 1, r.nextInt(10) + 1);
			area = ta.shapeArea;
			shape = "원";
			break;
		}
		
		System.out.printf("%s의 면적은 %d입니다.", shape, area);
		
	}
}

class Shape {
	int shapeArea;
	public  void area() {	
		
	}
}

class Rectangle extends Shape {
	public void area(int length) {
		shapeArea = length * length;
	}
}

class Triangle extends Shape {
	public void area(int length1, int length2) {
		shapeArea = length1 * length2 / 2;
	}
}

class Circle extends Shape {
	public void area(int length) {
		shapeArea = (int)((length*length)*3.14);
	}
}

class Square extends Rectangle {
	public void area(int length1, int length2) {
		shapeArea = length1 * length2;
	}
}