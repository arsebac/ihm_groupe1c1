package groupe1c1.controller;

import groupe1c1.model.ItemsManager;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.view.ProduitPhareView;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.awt.event.MouseAdapter;
import java.net.URL;
import java.util.EventListener;
import java.util.List;
import java.util.ResourceBundle;

public class ProduitController {

	@FXML
	private GridPane itemsGrid;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	private ItemsManager itemsManager;
	private ProduitPhareView view;

	@FXML
	void initialize() {
		view = new ProduitPhareView(itemsGrid);
		itemsManager = new ItemsManager();
		createItemList();
	}

	/**
	 * Affiche la grille de produit phares
	 */
	private void createItemList() {

		List<ItemPhare> phareList = itemsManager.getItemPhare();
		for (int i = 0; i < phareList.size(); i++) {
			ItemPhare item = phareList.get(i);
			view.drawItem(item.getName(), item.getUrl(), item.getCost(), i % 8, i / 8,createListener(item,false),createListener(item,true));
		}
	}
	private javafx.event.EventHandler<MouseEvent> createListener(final ItemPhare item,final boolean add){
		return new javafx.event.EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				clickItem(item,add);
			}
		};
	}
	public void clickItem(ItemPhare item,boolean add){
		System.out.println(item +" : "+add);
	}
}
