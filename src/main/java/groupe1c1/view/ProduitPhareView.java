package groupe1c1.view;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Classe permettant de représenter un item
 * @author user
 * @date 26/02/2017
 */
public class ProduitPhareView {

	private GridPane parent;

	public ProduitPhareView(GridPane parent) {
		this.parent = parent;
	}

	public void drawItem(String name, String url, double prix, int x, int y, EventHandler<MouseEvent> minusButtOnClick, EventHandler<MouseEvent> plusButtOnClick){
		try {
			BorderPane itemBorder = loadFxml();
			ImageView image = (ImageView) itemBorder.getCenter();
			image.setImage(new Image(url));
			Label itemName = (Label) ((BorderPane) itemBorder.getBottom()).getTop();
			Button left = (Button)((BorderPane) itemBorder.getBottom()).getLeft();
			left.setOnMouseClicked(minusButtOnClick);
			Button right = (Button)((BorderPane) itemBorder.getBottom()).getRight();
			right.setOnMouseClicked(plusButtOnClick);  //setOnMouseClicked(plusButtOnClick);
			itemName.setText(name+"\n"+prix+"€");
			parent.add(itemBorder,x,y);
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
