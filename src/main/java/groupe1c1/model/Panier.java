package groupe1c1.model;

import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.ItemPhare;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Desla on 01/03/2017.
 * @author Alexis Deslandes, Francois Melkonian
 */
public class Panier {
	private static Panier ourInstance = new Panier();
	private static Map<Affiche, Integer> affiches;
	private static Map<ItemPhare, Integer> items;
	public static Panier getInstance() {
		return ourInstance;
	}

	private Panier() {
		affiches = new HashMap<>();
		items = new HashMap<>();
	}
	public static void addItem(Affiche affiche){
		if(affiches.containsKey(affiche)){
			int newCount = 1 + affiches.get(affiche);
			affiches.replace(affiche,newCount);
		}else{
			affiches.put(affiche,1);
		}
	}
	public static int addItem(ItemPhare item){
		if(items.containsKey(item)){
			int newCount = 1 + items.get(item);
			items.replace(item,newCount);
			return newCount;
		}else{
			items.put(item,1);
			return 1;
		}
	}

	public static int delItem(ItemPhare item) {
		if(items.containsKey(item)){
			int newCount = items.get(item) - 1;
			if(newCount == 0){
				items.remove(item);
			}else{
				items.replace(item,newCount);
			}
			return newCount;
		}
		return 0;
	}
	public static void debug(){
		System.out.println(affiches);
		System.out.println(items);
	}
	public static double getTotalPrice(){
		int total = 0;
		for (Map.Entry<ItemPhare,Integer> item:
				items.entrySet()) {
			total += item.getKey().getCost() * item.getValue();
		}
		return total;
	}
	public static Set<Map.Entry<ItemPhare, Integer>> getItems(){
		return items.entrySet();
	}

	public static String getItemsPrice(ItemPhare item) {
		return (item.getCost() * items.get(item)) + "€";
	}
}
