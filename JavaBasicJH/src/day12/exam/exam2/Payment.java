package day12.exam.exam2;

public abstract class Payment implements Payable {
	protected String shopName;
	protected String productName;
	protected long productPrice;

	public Payment() {}
	public Payment(String shopName, String productName, long productPrice) {

	}
	
	public void payProcess() {
		
	}
}
