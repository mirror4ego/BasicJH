package day12.exam.exam1;

public class JavaBookSale implements Sale {
	Data d = new Data();

	public JavaBookSale() {
		d.setTitle("");
		d.setPrice(0);
		d.setPercent(0);
	}

	public JavaBookSale(String title, int price, int percent) throws PriceException {
		d.setTitle(title);
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
		return "책제목 : " + d.getTitle() + "\n가격 : " + d.getPrice() + "원\n할인율 : " + d.getPercent() + "%";
	}
}
