package groupe1c1.controller;

import groupe1c1.model.ItemsPharesManager;
import groupe1c1.model.data.ItemPhare;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.List;

/**
 * Contrôleur de la partie "Produits phares"  de la vue principale
 *
 * @author Francois Melkonian
 */
public class ProduitController {
	@FXML
	private GridPane itemsGrid;

	@FXML
	void initialize() {
		createItemList();
	}

	/**
	 * Affiche la grille de produit phares dans une GridBox.
	 */
	private void createItemList() {
		int sizeGrid = ItemsPharesManager.NUM_MAX_ITEM / 2;
		List<ItemPhare> phareList = ItemsPharesManager.getItemPhare();
		for (int i = 0; i < phareList.size(); i++) {
			ItemPhare item = phareList.get(i);
			drawItem(item, i % sizeGrid, i / sizeGrid);
		}
	}

	public void drawItem(ItemPhare item, int x, int y) {
		try {
			String fxmlFile = "/fxml/itemPhare.fxml";
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
			ItemController ic = new ItemController();
			loader.setController(ic);
			BorderPane itemBorder = loader.load();
			ic.draw(item);
			itemsGrid.add(itemBorder, x, y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
