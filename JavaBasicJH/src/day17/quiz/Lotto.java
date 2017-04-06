package day17.quiz;

import java.io.Serializable;

public class Lotto implements Serializable {
	private String LottoNo;
	private int no;
	
	public String getLottoNo() {
		return LottoNo;
	}
	public void setLottoNo(String lottoNo) {
		LottoNo = lottoNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public int compareTo(Lotto arr) {
		if (this.no > arr.getNo()) {
			return -1;	// 내림차순
		} else if (this.no == arr.getNo()) {
			return 0;	// 변동 없음
		} else {
			return 1;	// 내림차순
		}
	}
	
}
