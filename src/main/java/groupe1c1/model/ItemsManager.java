package groupe1c1.model;

import groupe1c1.model.data.ItemPhare;
import groupe1c1.model.parser.ItemParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 * @date 01/03/2017
 */
public class ItemsManager {
	private List<ItemPhare> actualItem;
	public ItemsManager() {
		actualItem = new ArrayList<>();
		init();
	}

	/**
	 * Récupère les items
	 */
	private void init() {
		try {
			ItemParser parser = new ItemParser("/properties.json");
			for (int i = 0; i < parser.itemSize(); i++) {
				actualItem.add(parser.getItem(i));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<ItemPhare> getItemPhare(){
		return  new ArrayList<>(actualItem);
	}
}
