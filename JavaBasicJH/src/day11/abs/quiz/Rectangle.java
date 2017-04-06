package day11.abs.quiz;

public class Rectangle extends Shape{
	private int side1;
	private int side2;
	public Rectangle() {}
	public Rectangle(int side1, int side2){
		this.side1 = side1;
		this.side2 = side2;
	}
	public void area() {
		System.out.println("직사각형의 면적 : " + (side1 * side2));
	}
}