/* 교육생 정보 처리 프로그램
 * 
 * 교육생 정보 등록
 * 이름 : 홍
 * 연락처 : 010-1111-1111
 * 성별(1. 남, 2. 여) : 1
 * 전공 여부(1. 전공, 2. 비전공) : 1
 * 추가 입력(Y/N) : N
 * 
 * 교육생 정보
 * ---------------------------------
 * 홍 	010-1111-1111	남	전공
 * ---------------------------------
 * 
 */
/*
* 교육생 정보 처리 프로그램
* 
* 교육생 정보 등록
* 이름 : 홍
* 연락처 : 010-111-1111
* 성별(1. 남, 2. 여) : 1
* 전공 여부(1. 전공, 2. 비전공) : 1
* 추가 입력(Y/N) : N
* 
* 교육생 정보
* --------------------------------------
* 홍 010-111-1111 남 전공
* -------------------------------------- 
*/
package day06.quiz;

import java.util.Scanner;

class Student {
	String name;
	String telNo;
	int gender;
	int major;
}

public class Test03 {
	public static void main(String[] args) {
		Student[] list = new Student[10];
		Scanner sc = new Scanner(System.in);

		int pos = 0;
		outer: while (true) {
			Student s = new Student();
			System.out.print("이름 : ");
			s.name = sc.nextLine();
			System.out.print("연락처 : ");
			s.telNo = sc.nextLine();
			System.out.print("성별(1. 남, 2. 여) : ");
			s.gender = Integer.parseInt(sc.nextLine());
			System.out.print("전공 여부(1. 전공, 2. 비전공) : ");
			s.major = Integer.parseInt(sc.nextLine());

			list[pos++] = s;

			System.out.print("추가 입력(Y/N) : ");
			String isContinue = sc.nextLine();
			switch (isContinue) {
			case "N":
			case "n":
				break outer;
			}
		}
		String[] genderArr = { "", "남", "여" };
		String[] majorArr = { "", "전공", "비전공" };
		System.out.println("교육생 정보");
		System.out.println("--------------------------------");
		for (int i = 0; i < pos; i++) {
			System.out.printf("%s\t%s\t%s\t%s\n", list[i].name, list[i].telNo, genderArr[list[i].gender],
					majorArr[list[i].major]);
		}
		System.out.println("--------------------------------");

	}
}
