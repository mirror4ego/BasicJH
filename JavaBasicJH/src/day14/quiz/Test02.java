/* 
 * [9, 5, 3]
 */
package day14.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Data implements Comparable<Data>{
	private int num;
	Data (int num) {
		this.num = num;
	}
	public int getNum() {return num;}
	
	public String toString() {
		String no = String.valueOf(num);
		return no;
	}
	
	// Comparable 인터페이스에 상속된 compareTo메소드를 재정의 해야한다.
	// 오름차순, 내림차순을 결과값을 이용하여 조절함
	public int compareTo(Data arr) {
		if (this.num > arr.getNum()) {
			return -1;	// 내림차순
		} else if (this.num == arr.getNum()) {
			return 0;	// 변동 없음
		} else {
			return 1;	// 내림차순
		}
	}
	
}

public class Test02 {
	public static void main(String[] args) {
		Data d1 = new Data(3);
		Data d2 = new Data(9);
		Data d3 = new Data(5);
		Data d4 = new Data(2);
		Data d5 = new Data(7);
		
		List<Data> list = new ArrayList<>();
		list.add(d1);
		list.add(d2);
		list.add(d3);
		list.add(d4);
		list.add(d5);
		
		System.out.println(list);
		
		// Collections
		
		Collections.sort(list);
		System.out.println(list);
		
		
		/*
		Data[] arr = {d1, d2, d3, d4, d5};
		for (int j = 0 ; j < arr.length; j++){
			for (int i = j+1 ; i < arr.length  ; i++) {
				if (arr[j].getNum() < arr[i].getNum()) {
					Data temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}			
		}
			
		// sort 의 기본조건
		// 배열의 요소가 Comparable 인터페이스 타입이어야 한다.
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		*/
		
		
	}
}
