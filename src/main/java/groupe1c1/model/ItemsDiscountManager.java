package groupe1c1.model;

import groupe1c1.model.data.ItemDiscount;
import groupe1c1.model.parser.ItemParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class ItemsDiscountManager {
	private static ItemsDiscountManager ourInstance = new ItemsDiscountManager();
	private static List<ItemDiscount> produitPhares;

	private ItemsDiscountManager() {
		produitPhares = new ArrayList<>();
		init();
	}

	public static ItemsDiscountManager getInstance() {
		return ourInstance;
	}

	/**
	 * Récupère les items
	 */
	private static void init() {
		try {
			ItemParser parser = new ItemParser("/properties.json");
			for (int i = 0; i < parser.itemSize(); i++) {
//					produitPhares.add(parser.getItem(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<ItemDiscount> getItemDiscount() {
		return new ArrayList<>(produitPhares);
	}

	public static void addItem(ItemDiscount item) {
		produitPhares.add(item);
	}

	public static void updateItem(ItemDiscount oldItem, ItemDiscount newItem) {
		produitPhares.remove(oldItem);
		produitPhares.add(newItem);
	}

	public static void remove(ItemDiscount item) {
		produitPhares.remove(item);
	}
}