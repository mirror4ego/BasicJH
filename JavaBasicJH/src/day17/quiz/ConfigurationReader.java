package day17.quiz;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigurationReader {
	String fName;
	char comment;
	String delm;
	HashMap<String, String> map;

	public ConfigurationReader(String fName) {
		this.fName = fName;
		this.comment = '#'; // 주석 구분자 #기호
		this.delm = "=>"; // 서버 정보 구분자 = 기호
		map = new HashMap<>(); // 정보를 파싱하여 key, value 쌍으로 저장하기 위한 공간
	}

	public String getValue(String name) {
		String key = map.get(name);
		return key;
	}

	public void parse() throws IOException {
		File f = new File(fName);
		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.startsWith(comment+"")==false) {
				if (line.startsWith("-")==false) {
						String [] arr = line.split(delm);
						map.put(arr[0], arr[1]);
				}
			}
		}
	}
}
