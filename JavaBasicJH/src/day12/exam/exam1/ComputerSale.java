package day12.exam.exam1;

public class ComputerSale implements Sale {
	Data d = new Data();

	public ComputerSale() {
		d.setProductName("");
		d.setPrice(0);
		d.setPercent(0);
	}

	public ComputerSale(String productName, int price, int percent) throws PriceException {
		d.setProductName(productName);
		d.setPrice(price);
		d.setPercent(percent);
		if (price <= 0 || percent >= 50) {
			throw new PriceException("가격 또는 할인율이 잘못되었습니다.");
		}
	}

	@Override
	public int calculatePrice() {
		return d.getPrice() * d.getPercent() / 100;
	}

	public String toString() {
		return "제품명 : " + d.getProductName() + "\n가격 : " + d.getPrice() + "원\n할인율 : " + d.getPercent() + "%";
	}
}
