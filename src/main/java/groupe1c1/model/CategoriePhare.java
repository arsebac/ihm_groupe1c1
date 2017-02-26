package groupe1c1.model;

/**
 * @author user
 * @date 26/02/2017
 */
public enum CategoriePhare {
	UNDEFINED(-1,"undefined"),HIGHTECH(0,"High-tech"),CUISINE(1,"Cuisine"),SPORT(2,"Sport"),JOUETS(3,"Jouet"),JARDIN(4,"Jardin");

	private final String name;
	private final int id;

	CategoriePhare(int id, String name) {
		this.id =id;
		this.name =name;
	}
	public static CategoriePhare get(int idCat){
		for (CategoriePhare cat :
				values()) {
			if(cat.id == idCat) return cat;
		}
		return UNDEFINED;
	}

	public static CategoriePhare get(String name){
		for (CategoriePhare cat :
				values()) {
			if(cat.name.equals(name)) return cat;
		}
		return UNDEFINED;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public static int size() {
		return values().length;
	}

	public boolean canShowCategory() {
		return id != UNDEFINED.id;
	}
}
