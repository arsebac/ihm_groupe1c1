package groupe1c1.model;

/**
 * Représentatation d'un item phare
 * @author François Melkonian
 * @date 26/02/2017
 */
public class ItemPhare {
	public  final String nom;
	public  final CategoriePhare categorieId;
	public  final double prix;

	public ItemPhare(String nom, int categorieId, double prix) {
		this.nom = nom;
		this.categorieId = CategoriePhare.get(categorieId);
		this.prix = prix;
	}


	public String getName() {
		return nom;
	}

	public double getCost() {
		return prix;
	}
}
