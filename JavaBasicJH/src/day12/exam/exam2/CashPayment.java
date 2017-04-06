package day12.exam.exam2;

public class CashPayment extends Payment {
	private String cashReceipNumber;

	public CashPayment(String shopName, String productName, long productPrice, String cashReceipNumber) {
		super.shopName =shopName;
		super.productName = productName;
		super.productPrice = productPrice;
		this.cashReceipNumber = cashReceipNumber;
	}
	
	public void pay() throws PayException {
		try {
			if (productPrice <= 0 ) {
				throw new PayException("가격이 잘못되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	public String toString() {
		return "현금이 정상적으로 지불되었습니다.\n" + "[ 현금 결제 정보 ]\n" + "상점명 : " + shopName + "\n상품명 : " + productName + "\n상품가격 : "+ productPrice + "\n현금영수증번호 : " + cashReceipNumber;
	}

}