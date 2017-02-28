package groupe1c1.view;

import groupe1c1.ProduitController;
import groupe1c1.model.CategoriePhare;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Classe permettant de représenter un item
 * @author user
 * @date 26/02/2017
 */
public class ProduitPhareView {

	private GridPane parent;
	private final VBox category;

	public ProduitPhareView(GridPane parent, VBox category) {
		this.parent = parent;
		this.category = category;
	}

	public BorderPane drawItem(String name,String url,double prix){
		try {
			String fxmlFile = "/fxml/itemPhare.fxml";
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
			BorderPane itemBorder = loader.load();
			ImageView image = (ImageView) itemBorder.getCenter();
			image.setImage(new Image(url));
			Label itemName = (Label) ((BorderPane) itemBorder.getBottom()).getTop();
			itemName.setText(name+"\n"+prix+"€");
			return itemBorder;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Ajoute une catégorie dans la liste de catégorie
	 * @param item la catégorie à afficher
	 * @param controller le controleur qui recevra l'évènement du clic sur la catégorie
	 */
	public void drawCategory(CategoriePhare item, final ProduitController controller){
		try {
			final String nameCat = item.getName();
			String fxmlFile = "/fxml/cat.fxml";
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
			Label categoryLabel = loader.load();
			categoryLabel.setPrefHeight(65);
			categoryLabel.setText(nameCat);
			categoryLabel.setOnMouseClicked(event -> controller.onClickCategory(item));
			category.getChildren().add(categoryLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
