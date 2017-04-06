/*
 * 	실행시의 결과 출력 형식
 * 	파일형식 : 이름:자바:SQL:Jdbc
 * 	수료기준
 *  - 자바 : 70이상
 *  - SQL: 80이상
 *  - Jdbc:80이상
 *  단, 출력결과는 score-result.txt.에 출력
 * 
 * 	김기수 : 자바(수료), SQL(미수료), Jdbc(미수료)
 * 	이지수 : 자바(수료), SQL(미수료), Jdbc(수료)
 * 	박수리 : 자바(수료), SQL(수료), Jdbc(미수료)
 */
package day16.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Data {
	String name;
	String java;
	String sql;
	String jdbc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getJdbc() {
		return jdbc;
	}
	public void setJdbc(String jdbc) {
		this.jdbc = jdbc;
	}
}

public class Test01 {
	public static void main(String[] args) throws Exception {
		File f = new File("data/score.txt");
		Scanner sc = new Scanner(f);
		ArrayList<Data> list = new ArrayList<>();
		while (sc.hasNextLine()) {
			String[] arr = sc.nextLine().split(":");
			String name =  arr[0];
			String javaResult = "미수료";
			String sqlResult = "미수료";
			String jdbcResult = "미수료";
			if (Integer.parseInt(arr[1]) >= 70) {
				javaResult = "수료";
			}
			if (Integer.parseInt(arr[2]) >= 80) {
				sqlResult = "수료";
			}
			if (Integer.parseInt(arr[3]) >= 80) {
				jdbcResult = "수료";
			}
			Data d = new Data();
			d.setName(name);
			d.setJava("자바("+javaResult+")");
			d.setSql("SQL("+sqlResult+")");
			d.setJdbc("Jdbc("+jdbcResult+")");
			list.add(d);
		}
		
		FileWriter fw = new FileWriter("data/score-result.txt");
		PrintWriter pw = new PrintWriter(fw);
		int count = 0;
		for (Data d : list){
			pw.print(d.getName() + ":"+ d.getJava()+","+d.getSql()+","+d.getJdbc());
			if (++count < list.size()) {
				pw.println();
			}
		}
		fw.close();
		pw.close();
	}
}