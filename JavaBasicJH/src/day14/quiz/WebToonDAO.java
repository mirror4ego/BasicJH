package day14.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class WebToonDAO {
	ArrayList<WebToonVO> list = new ArrayList<>();
	Calendar c = Calendar.getInstance();
	
	public void insertWebToon() throws FileNotFoundException {
		File f = new File("src/day14/quiz/Webtoon.txt");
		Scanner fs = new Scanner(f);
		while (fs.hasNextLine()) {
			WebToonVO data = new WebToonVO();
			String[] tw = fs.nextLine().split(":");
			data.setNo(Integer.parseInt(tw[0]));
			data.setTitle(tw[1]);
			String days="";
			switch (Integer.parseInt(tw[2])) {
			case 1 : days="일요일"; break;
			case 2 : days="월요일"; break;
			case 3 : days="화요일"; break;
			case 4 : days="수요일"; break;
			case 5 : days="목요일"; break;
			case 6 : days="금요일"; break;
			case 7 : days="토요일"; break;
			}
			data.setDay(days);
			data.setWriter(tw[3]);
			switch (Integer.parseInt(tw[4])) {
			case 1 : tw[4] = "판타지"; break;
			case 2 : tw[4] = "무협"; break;
			case 3 : tw[4] = "순정"; break;
			case 4 : tw[4] = "액션"; break;
			case 5 : tw[4] = "SF"; break;
			case 6 : tw[4] = "학원물"; break;
			}
			data.setGenre(tw[4]);
			data.setScore(Double.parseDouble(tw[5]));
			list.add(data);
		}
		
	}
	
	public ArrayList<WebToonVO> selectAll () {
		return list;
	}
	
	public String[] selectWriter () {
		String[] tempWArr = new String[list.size()];
		for (int i = 0 ; i < list.size(); i++){
			WebToonVO data = list.get(i);
			tempWArr[i] = data.getWriter();	
		}
		return tempWArr;
	}
	
	public String[] selectGenre () {
		String[] tempGArr = new String[list.size()];
		for (int i = 0 ; i < list.size(); i++){
			WebToonVO data = list.get(i);
			tempGArr[i] = data.getGenre();	
		}
		return tempGArr;
	}
	
	public double[] selectScore () {
		double[] tempSArr = new double[list.size()];
		for (int i = 0 ; i < list.size(); i++){
			WebToonVO data = list.get(i);
			tempSArr[i] = data.getScore();	
		}
		return tempSArr;
	}
	
	public String[] selectTitle () {
		String[] tempTArr = new String[list.size()];
		for (int i = 0 ; i < list.size(); i++){
			WebToonVO data = list.get(i);
			tempTArr[i] = data.getTitle();	
		}
		return tempTArr;
	}
	
}
