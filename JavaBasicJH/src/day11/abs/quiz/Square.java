package day11.abs.quiz;

public class Square extends Rectangle {
	private int side;
	public Square(int side) {
//		super();
		this.side = side;
	}
	public void area() {
		System.out.println("정사각형의 면적 : " + (side * side));
	}
}
