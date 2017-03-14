package groupe1c1.model;

import groupe1c1.model.data.ItemDiscount;
import groupe1c1.model.data.ItemPhare;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Desla on 01/03/2017.
 *
 * @author Alexis Deslandes, Francois Melkonian
 */
public class Panier {
	private static Panier ourInstance = new Panier();
	private static Map<ItemDiscount, Integer> promotions;
	private static Map<ItemPhare, Integer> items;

	private Panier() {
		promotions = new HashMap<>();
		items = new HashMap<>();
	}

	public static void resetPanier(){
        ourInstance = new Panier();
    }

	public static Panier getInstance() {
		return ourInstance;
	}

	public static void addItem(ItemDiscount affiche) {
		if (promotions.containsKey(affiche)) {
			int newCount = 1 + promotions.get(affiche);
			promotions.replace(affiche, newCount);
		} else {
			promotions.put(affiche, 1);
		}
	}

	public static int addItem(ItemPhare item) {
		if (items.containsKey(item)) {
			int newCount = 1 + items.get(item);
			items.replace(item, newCount);
			return newCount;
		} else {
			items.put(item, 1);
			return 1;
		}
	}

	public static int delItem(ItemPhare item) {
		if (items.containsKey(item)) {
			int newCount = items.get(item) - 1;
			if (newCount == 0) {
				items.remove(item);
			} else {
				items.replace(item, newCount);
			}
			return newCount;
		}
		return 0;
	}

	public static double getTotalPrice() {
		int total = 0;
		for (Map.Entry<ItemPhare, Integer> item :
				items.entrySet()) {
			total += item.getKey().getCost() * item.getValue();
		}
		for (Map.Entry<ItemDiscount, Integer> item :
				promotions.entrySet()) {
			total += item.getKey().getCost() * item.getValue() * (1 - item.getKey().getDiscount() / 100);
		}
		return total;
	}

	public static Set<Map.Entry<ItemPhare, Integer>> getItems() {
		HashMap<ItemPhare, Integer> map = new HashMap<>();
		map.putAll(promotions);
		map.putAll(items);
		return map.entrySet();
	}

	public static String getItemsPrice(ItemPhare item) {
		if (items.containsKey(item)) {
			return Math.round((item.getCost() * items.get(item)) * 100.0) / 100.0 + "€";
		} else {
			ItemDiscount discount = (ItemDiscount) item;
			return Math.round(discount.getCost() * promotions.get(discount) * (1 - discount.getDiscount() / 100) * 100.0) / 100.0 + "€";
		}
	}
}
