/**
 * 		String s = "1:hong:22-2:kim:33-3:lee:44";
 * 		위의 내용을 가지고 있는 문자열이 있을때 아래와 같이 정보가 출력되도록 하시오.		
 */
package day08.quiz;

public class Test05 {
	public static void main(String[] args) {
		String s = "1:hong:22-2:kim:33-3:lee:44";
		String[]arr = s.split("-");
		for (String info : arr) {
			String[]pInfo = info.split(":");
			System.out.printf("%s번 학생\n", pInfo[0]);
			System.out.printf("아이디 : %s\n", pInfo[1]);
			System.out.printf("나이 : %s세\n", pInfo[2]);
		}
		
	}
}
