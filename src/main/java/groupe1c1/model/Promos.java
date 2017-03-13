package groupe1c1.model;

import groupe1c1.model.data.ItemDiscount;
import groupe1c1.persistence.json.gson.EnseigneDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Modèle des promotions.
 * @author François Melkonian
 * @date 08/03/2017
 */
public class Promos {
	private static Promos ourInstance = new Promos();
	private static List<ItemDiscount> affiches;
	private static EnseigneDeserializer data;
	private static int start;
	private Promos() {
		try {
			data  = new EnseigneDeserializer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		start = 0;
		affiches = data.getItemDiscount();
	}
	public static Promos getInstance() {
		return ourInstance;
	}
	public static List<ItemDiscount> getPromos(){
		return affiches.subList(start,Math.min(3 + start, affiches.size()));
	}
	public static ItemDiscount getNiemeAffiche(int n){
		return affiches.get(start+ n);
	}

	public static void left() {
		if(start > 0) start --;
	}
	public static void right() {
		if(start + 4<affiches.size()) start ++;
	}

	public static List<ItemDiscount> getAffiches() {
		return affiches;
	}

	public static List<ItemDiscount> getItemDiscount(){
		return new ArrayList<>(affiches);
	}
	public static void addItem(ItemDiscount item){
		affiches.add(item);
	}

	public static void updateItem(ItemDiscount oldItem, ItemDiscount newItem) {
		affiches.remove(oldItem);
		affiches.add(newItem);
	}

	public static void remove(ItemDiscount item) {
		affiches.remove(item);
	}
}
