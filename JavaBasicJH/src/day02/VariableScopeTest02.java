package day02;

public class VariableScopeTest02 {
	public static void main(String[] args)
	{
	// int i = 0; 오류발생 중복선언
			
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i);
		}
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println(i);
		}

  //int i=0; 괜찮음
		
//System.out.println(i); 오류발생
		
	
	if (true) 
	{
		 int a = 100;
		 System.out.println(a);
	}
//System.out.println(a); 오류발생

	}
	}
