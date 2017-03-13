package groupe1c1.model.data;

/**
 * Created by Desla on 05/03/2017.
 */
public class ItemDiscount extends ItemPhare {

	private double discount;

	public ItemDiscount(String nom, double prix, double discount, String url) {
		super(nom, prix, url);
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	@Override
	public String toString() {
		return "ItemPromotion{" +
				"nom='" + nom + '\'' +
				", url='" + url + '\'' +
				", prix=" + prix + '\'' +
				", discount=" + discount +
				'}';
	}
}
