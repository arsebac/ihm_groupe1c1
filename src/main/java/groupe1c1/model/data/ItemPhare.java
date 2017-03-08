package groupe1c1.model.data;

/**
 * Représentatation d'un item phare
 * @author François Melkonian
 * @date 26/02/2017
 */
public class ItemPhare {
	private final String nom;
	private final String url;
	private final double prix;

	public ItemPhare(String nom, double prix, String url) {
		this.nom = nom;
		this.prix = prix;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public String getName() {
		return nom;
	}

	public double getCost() {
		return prix;
	}

	@Override
	public String toString() {
		return "ItemPhare{" +
				"nom='" + nom + '\'' +
				", url='" + url + '\'' +
				", prix=" + prix +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ItemPhare itemPhare = (ItemPhare) o;

		if (Double.compare(itemPhare.prix, prix) != 0) return false;
		if (nom != null ? !nom.equals(itemPhare.nom) : itemPhare.nom != null) return false;
		return url != null ? url.equals(itemPhare.url) : itemPhare.url == null;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = nom != null ? nom.hashCode() : 0;
		result = 31 * result + (url != null ? url.hashCode() : 0);
		temp = Double.doubleToLongBits(prix);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
