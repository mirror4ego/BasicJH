
package day03.exam.If;

import java.util.Scanner;

public class Test03 {
	public static void main(String [] args){
		
		System.out.print("첫번째 숫자를 입력하세요 : ");
		Scanner sc1 = new Scanner(System.in);
		int i1 = Integer.parseInt(sc1.nextLine());
		
		System.out.print("두번째 숫자를 입력하세요 : ");
		Scanner sc2 = new Scanner(System.in);
		int i2 = Integer.parseInt(sc2.nextLine());
		
		System.out.print("세번째 숫자를 입력하세요 : ");
		Scanner sc3 = new Scanner(System.in);
		int i3 = Integer.parseInt(sc3.nextLine());
		
		int max = i2;
		int min = i2;
		
		if (i1>i2) {
			if (i1>i3) {
				max = i1;
			}
			else{
				max = i3;
				}						
		}
		
		if (i3>i2) {
			max = i3;
		}
		
		if (i1<i2) {
				if (i1<i3) {
					min = i1;
				}
				else {
					min = i3;	
				}
			}
		if (i3<i2) {
			min = i3;
		}
				
		
		System.out.printf("최대값 : %d, 최소값 : %d", max, min);
		
	}
		}
		