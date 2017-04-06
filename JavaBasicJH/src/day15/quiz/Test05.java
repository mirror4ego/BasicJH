package day15.quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) {
		copy("data/a.txt", "data/aa/bb/acopy.txt");
		copy("data/a.txt", "data/aa/bb");
	}
	
	public static void copy(String s, String d) {

		File fs = new File(s);
		File fd = new File(d);
		
		if (fd.getName().contains(".") == true) {
			File f = new File(fd.getParent());
			f.mkdirs();
			d = fd.getParent() +"/"+ fd.getName();
			System.out.println(d);
		} else {
			fd.mkdirs();
			d = fd.getPath() +"/"+ fs.getName();
		}
		
		
		
		FileInputStream fr = null;
		FileOutputStream fw = null;
		
		try {
			fr = new FileInputStream(s);
			fw = new FileOutputStream(d);

			long sTime = System.currentTimeMillis();

			byte[] buffer = new byte[32 * 1024 * 2];

			while (true) {
				int ch = fr.read(buffer);
				if (ch == -1)
					break;
				fw.write(buffer, 0, ch);
			}
			double time = (System.currentTimeMillis() - sTime) / 1000d;
			System.out.println("복사에 걸린 시간 : " + time);
			System.out.println("복사 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
