package day12;

import java.util.Random;

public class LottoService {
	public void execute() throws LottoException {
		Random r = new Random();
		int num = r.nextInt(100) + 1;
		System.out.println("로또 번호 : " + num);
		
		if ( num > 45 ) {
			throw new LottoException(num);
		}
		else {
			System.out.println("로또 번호가 올바르게 생성되었습니다.");
		}
	}
}
