package day02.exam;

public class OperationTest06 {
	public static void main(String [] args){
	int a1 = (short)'A';
	int z1 = (short)'Z';
	int a2 = (short)'a';
	int z2 = (short)'z';
	
	int result1 = (a1>z1)?a1-z1+1:z1-a1+1;
	int result2 = (a2>z2)?a2-z2+1:z2-a2+1;
	
	System.out.printf("결과 ? %d", result1+result2);
	}
}
