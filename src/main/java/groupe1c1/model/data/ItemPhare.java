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
}
