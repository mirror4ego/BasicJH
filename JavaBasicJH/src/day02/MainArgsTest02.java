package day02;

public class MainArgsTest02 {
	public static void main(String[] args){
		System.out.println(args.length);
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[0] + args[1]);
		
		
//		int i = "100"; 		// 오류발생함
//		int i = args[0];    // 오류발생함		
		
		int i = Integer.parseInt(args[0]);
		int j = Integer.parseInt(args[1]);
		System.out.println(i);
		System.out.println(j);
		System.out.println(i+j);
		
		
		
	}
}
