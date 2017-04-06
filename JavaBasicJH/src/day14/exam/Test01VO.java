package day14.exam;

public class Test01VO implements Comparable<Test01VO> {
	String group;
	int java;
	int sql;
	int jsp;
	
	public Test01VO () {
		
	}
	
	public Test01VO(String group, int java, int sql, int jsp) {
		super();
		this.group = group;
		this.java = java;
		this.sql = sql;
		this.jsp = jsp;
	}
	
	public int compareTo(Test01VO arr) {
		if (this.java > arr.getJava()) {
			return -1;	// 내림차순
		} else if (this.java == arr.getJava()) {
			return 0;	// 변동 없음
		} else {
			return 1;	// 내림차순
		}
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	
	public String toString() {
		return group +" "+ java+" " + sql+ " "+ jsp;
	}
}