package groupe1c1;

import groupe1c1.model.CategoriePhare;
import groupe1c1.model.ItemPhare;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author user
 * @date 26/02/2017
 */
public class Enseigne {
	private Map<CategoriePhare,List<ItemPhare>> items;
	public Enseigne() {
		items = new HashMap<>();
		initItems();
	}

	private void initItems() {
		for (int i = 0; i < CategoriePhare.size(); i++) {
			initItemsByCategory(i);
		}
	}

	private void initItemsByCategory(int id) {
		CategoriePhare cat = CategoriePhare.get(id);
		List<ItemPhare> itemsList = new ArrayList<>();
		for (int i = 0; i < 16; i++) {
				ItemPhare item = new ItemPhare(cat.getName()+" - "+(i+1),i,12.5 + i);
				itemsList.add(item);
		}
		items.put(cat,itemsList);
	}
	public List<ItemPhare> getCategory(int i){
		return items.get(CategoriePhare.get(i));
	}

	public Stream<CategoriePhare> getCategoryMenu() {
		return Arrays.stream(CategoriePhare.values()).filter(e->e.canShowCategory());
	}
}
