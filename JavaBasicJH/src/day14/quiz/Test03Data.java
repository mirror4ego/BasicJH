package day14.quiz;

public class Test03Data {
	private String name;
	private int score;
	
	public Test03Data() {
		
	}
	
	public Test03Data(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		return "이름 : "+ name + " / "+ "점수 : " + score;
	}

}
