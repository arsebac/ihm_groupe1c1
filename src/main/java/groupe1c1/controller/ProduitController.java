package groupe1c1.controller;

import groupe1c1.model.ItemsManager;
import groupe1c1.model.data.ItemPhare;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
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

	@FXML
	void initialize() {
		itemsManager = new ItemsManager();
		createItemList();
	}

	/**
	 * Affiche la grille de produit phares
	 */
	private void createItemList() {
		int sizeGrid = 7;
		List<ItemPhare> phareList = itemsManager.getItemPhare();
		for (int i = 0; i < phareList.size(); i++) {
			ItemPhare item = phareList.get(i);
			drawItem(item, i % sizeGrid, i / sizeGrid);
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

	public void drawItem(ItemPhare item ,int x, int y){
		try {
			BorderPane itemBorder = loadFxml();
			ImageView image = (ImageView) itemBorder.getCenter();
			image.setImage(new Image(item.getUrl()));
			Label itemName = (Label) ((BorderPane) itemBorder.getBottom()).getTop();
			Button left = (Button)((BorderPane) itemBorder.getBottom()).getLeft();
			left.setOnMouseClicked(createListener(item,false));
			Button right = (Button)((BorderPane) itemBorder.getBottom()).getRight();
			right.setOnMouseClicked(createListener(item,true));
			itemName.setText(item.renderText());
			itemsGrid.add(itemBorder,x,y);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private BorderPane loadFxml() throws IOException {
		String fxmlFile = "/fxml/itemPhare.fxml";
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
		return loader.load();
	}
}
