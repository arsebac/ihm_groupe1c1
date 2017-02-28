package groupe1c1;

import groupe1c1.model.CategoriePhare;
import groupe1c1.model.ItemPhare;
import groupe1c1.view.ProduitPhareView;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProduitController {

	@FXML
	private GridPane itemsGrid;
	@FXML
	private VBox catList;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	private Enseigne enseigne;
	private ProduitPhareView view;

	@FXML
	void initialize() {
		view = new ProduitPhareView(itemsGrid,catList);
		enseigne = new Enseigne();
		//enseigne.getCategoryMenu().forEach(cat -> view.drawCategory(cat, this));
		createItemListByCategory(0);
	}

	/**
	 * Affiche la grille de produit phares
	 * @param id l'identifiant de la categorie à afficher
	 */
	private void createItemListByCategory(int id) {
		List<ItemPhare> phareList = enseigne.getCategory(id);
		for (int i = 0; i < phareList.size(); i++) {
			ItemPhare item = phareList.get(i);
			BorderPane itemDraw = view.drawItem(item.getName(), "images/tel.jpg", item.getCost());
			itemsGrid.add(itemDraw, i % 8, i / 8);
		}
	}

	public void onClickCategory(CategoriePhare nameCat) {
		itemsGrid.getChildren().clear();
		int id = nameCat.getId();
		createItemListByCategory(id);
	}
}
