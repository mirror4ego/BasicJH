package day14.quiz;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WebToonUI {
	Scanner sc = new Scanner(System.in);
	WebToonDAO dao = new WebToonDAO();
	

	public void start() throws FileNotFoundException {
		dao.insertWebToon();
		while (true) {
			System.out.println("웹툰 관리 프로그램");
			System.out.println("----------------");
			System.out.println("1. 전체조회");
			System.out.println("2. 작가조회");
			System.out.println("3. 장르조회");
			System.out.println("4. 평점조회");
			System.out.println("5. 제목조회");
			System.out.println("6. 종료");
			System.out.println("----------------");
			System.out.print("메뉴 (1 - 6) : ");
			int mNo = Integer.parseInt(sc.nextLine());
			switch (mNo) {
			case 1:
				searchAll();
				break;
			case 2:
				writer();
				break;
			case 3:
				genre();
				break;
			case 4:
				score();
				break;
			case 5:
				title();
				break;
			case 6:
				exit();
			}
		}

	}

	public void searchAll() {
		ArrayList<WebToonVO> list = dao.selectAll();
		for (int i = 0 ; i < list.size(); i++){
			WebToonVO w = list.get(i);
			System.out.printf("%04d\t%s\t%s\t%s\t%s\t%.2f\n", w.getNo(), w.getTitle(),w.getDay(), w.getWriter(), w.getGenre(), w.getScore());
		}
	}
		
	public void writer() {
		System.out.println(Arrays.toString(dao.selectWriter()));
	}

	public void genre() {
		System.out.println(Arrays.toString(dao.selectGenre()));
	}

	public void score() {
		System.out.println(Arrays.toString(dao.selectScore()));
	}

	public void title() {
		System.out.println(Arrays.toString(dao.selectTitle()));
	}

	public void exit() {
		System.exit(0);
	}
}
