package day17.quiz;

public class Exam04 {
	public static void main(String[] args) {
		ConfigurationReader cr = new ConfigurationReader("data/myserver.txt");
		try {
			cr.parse();
			System.out.println(cr.getValue("port"));
			System.out.println(cr.getValue("server"));
			System.out.println(cr.getValue("admin"));
		} catch (Exception e) {
		}
	}
}
