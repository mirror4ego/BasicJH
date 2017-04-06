package day12;

public class ExceptionTest09 {
	public static void main(String[] args) {
		LottoService ls = new LottoService();
		try {
			ls.execute();			
		} catch (LottoException e) {
			e.printStackTrace();
		}
	}
}
