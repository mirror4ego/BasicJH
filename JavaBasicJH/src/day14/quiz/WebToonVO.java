package day14.quiz;

public class WebToonVO {
	private int no;
	private String title;
	private String day;
	private String writer;
	private String genre;
	private double score;
	
	public WebToonVO() {
		
	}
	
	public WebToonVO(int no, String title, String day, String writer, String genre, double score) {
		super();
		this.no = no;
		this.title = title;
		this.day = day;
		this.writer = writer;
		this.genre = genre;
		this.score = score;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public String toString() {
		return no+ "\t" + title +"\t"+ day + "\t\t" + writer + "\t" + score+ " "; 
	}
	
}
