package day07.exam;

public class MethodUtil {

	boolean isUpperChar (char c){
		if (c >= 'A') {
			if (c <= 'Z') {
				return true;
			}
		}
		return false;		
	}
	
	boolean isLowerChar (char c){
		if (c >= 'a') {
			if (c <= 'z') {
				return true;
			}
		}
		return false;		
	}
	
	int max (int i, int j){
		return (i > j)?i:j;		
	}
	
	int min (int i, int j){
		return (i < j)?i:j;		
	}
	
	int abs(int i) {
		if (i<0) {
			i = i - (2*i);
		}
		return i;
	}
	
}
