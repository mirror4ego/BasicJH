package day11.abs.quiz;

public class Circle extends Shape {
	private int radius;
	public Circle (int radius) {
		this.radius =  radius;
	}
	
	public void area() {
		System.out.println("원의 넓이 : "+ (int)(radius*radius*Math.PI));
	}
}
