

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MultipartRequest {
	
	public MultipartRequest(String file) throws FileNotFoundException {
		File f = new File("src/day16/exam/"+file);
		Scanner sc = new Scanner(f);
		String sum = null;
		while (sc.hasNextLine()){
			sum += sc.nextLine();			
		}
		String[] part = sum.split("------WebKitFormBoundary2DYFs87zeHyw9BZx--");
		Arrays.toString(part);
		
		
		
	}

	public String getParameter(String string) {
		return null;
	}

	public String[] getFiles() {
		return null;
	}
}
