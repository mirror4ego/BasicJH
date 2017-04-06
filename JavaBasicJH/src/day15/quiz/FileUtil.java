package day15.quiz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileUtil {
	public static boolean mkDir() { 
		// 현재 시간 정보를 얻어와
		// 년 월 일에 해당하는 디렉토리를 생성한다.
		// data/2016/07/15
		/*
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		File f = new File("data/"+year+"/"+String.format("%02d", month)+"/"+date);
		return f.mkdirs();
		*/
		
		// SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		File f = new File("data"+sdf.format(new Date()));
		return f.mkdirs();
	}
}
