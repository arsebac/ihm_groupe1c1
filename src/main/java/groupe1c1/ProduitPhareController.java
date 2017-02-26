package groupe1c1;

import groupe1c1.model.CategoriePhare;
import groupe1c1.model.ItemPhare;
import groupe1c1.view.ItemCategoryView;
import groupe1c1.view.ItemView;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProduitPhareController {

	@FXML
	private GridPane itemsGrid;
	@FXML
	private VBox catList;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	private List<ItemPhare> items;
	private Enseigne enseigne;
	private ItemView view;
	private ItemCategoryView categoryView;

	@FXML
	void initialize() {
		items = new ArrayList<>();
		view = new ItemView(itemsGrid);
		categoryView = new ItemCategoryView(catList);
		enseigne = new Enseigne();
		categoryView.drawCategory(enseigne.getCategoryMenu(), this);
		initDisplayItems(0);

	}

	private void initDisplayItems(int id) {
		List<ItemPhare> phareList = enseigne.getCategory(id);
		for (int i = 0; i < phareList.size(); i++) {
			ItemPhare item = phareList.get(i);
			BorderPane itemDraw = view.drawItem(item.getName(), "images/11752936341534.jpg", item.getCost());
			itemsGrid.add(itemDraw, i % 4, i / 4);
		}
	}

	public void detectClick(String nameCat) {
		itemsGrid.getChildren().clear();
		int id = CategoriePhare.get(nameCat).getId();
		initDisplayItems(id);
	}
}
