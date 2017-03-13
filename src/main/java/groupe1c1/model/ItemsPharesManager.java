package groupe1c1.model;

import groupe1c1.model.data.ItemPhare;
import groupe1c1.model.parser.ItemParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton gardant en mémoire les produits phares à afficher
 * @author François Melkonian
 * @date 01/03/2017
 */
public class ItemsPharesManager {
	private static ItemsPharesManager ourInstance = new ItemsPharesManager();
	public static int MAX_ITEM = 12;
	private static List<ItemPhare> produitPhares;
	private ItemsPharesManager() {
		System.out.println("chargement");
		produitPhares = new ArrayList<>();
		init();
	}
	public static ItemsPharesManager getInstance() {
		return ourInstance;
	}

	/**
	 * Récupère les items
	 */
	private static void init() {
		try {
			ItemParser parser = new ItemParser("/properties.json");
			for (int i = 0; i < parser.itemSize(); i++) {
				produitPhares.add(parser.getItem(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static List<ItemPhare> getItemPhare(){
		return new ArrayList<>(produitPhares);
	}
	public static void addItem(ItemPhare item){
		produitPhares.add(item);
	}

	public static void updateItem(ItemPhare oldItem, ItemPhare newItem) {
		produitPhares.remove(oldItem);
		produitPhares.add(newItem);
	}

	public static void remove(ItemPhare item) {
		System.out.println(produitPhares);
		produitPhares.remove(item);
		System.out.println(produitPhares);
	}
}
