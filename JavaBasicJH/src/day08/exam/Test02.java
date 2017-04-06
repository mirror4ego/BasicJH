package day08.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/day08/exam/word.txt");
		Scanner sc = new Scanner(f);

		/**
		 * 단어 개수 카운트해서 배열길이 정해주기
		 */
		int count = 0;
		while (sc.hasNext()) {
			count++;
			sc.next();
		}

		/**
		 * 알파벳으로만 구성된 단어 뽑아서 배열에 넣기
		 */
		String[] word = new String[count];
		int[] amount = new int[count];
		sc = new Scanner(f);
		for (int i = 0; i < count; i++) {
			word[i] = sc.next();
			for (int j = 0; j < word[i].length(); j++) {
				word[i] = word[i].replaceAll("[^A-Za-z]{1,}", "");
			}
		}
		
		/**
		 * 중복단어 찾아서 지워주고 카운트 올리기
		 */
		for (int i = 0; i < count; i++) {
			amount[i] = 1;
			for (int j = i + 1; j < count; j++) {
				if (word[i].equals(word[j])) {
					System.arraycopy(word, j + 1, word, j, count - j - 1);
					amount[i]++;
					count--;
				}
			}
		}

		/**
		 * 중복 단어 개수에 따라 내림차순으로 정렬하기
		 */
		String tempWord;
		int tempNum;
		for (int i = 0; i < count; i++) {
			for (int j = i; j < count; j++) {
				if (amount[i] < amount[j]) {
					tempWord = word[i];
					word[i] = word[j];
					word[j] = tempWord;

					tempNum = amount[i];
					amount[i] = amount[j];
					amount[j] = tempNum;
				}
			}
		}
		
		/**
		 * 결과값 출력해주기
		 */
		for (int i = 0; i < count; i++) {
			System.out.printf("%s\t%d \n", word[i], amount[i]);
		}

	}
}
