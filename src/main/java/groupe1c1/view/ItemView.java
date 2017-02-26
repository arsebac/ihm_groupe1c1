package groupe1c1.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Classe permettant de représenter un item
 * @author user
 * @date 26/02/2017
 */
public class ItemView {

	private GridPane parent;

	public ItemView(GridPane parent) {
		this.parent = parent;
	}

	public BorderPane drawItem(String name,String url,double prix){
		BorderPane cadre = new BorderPane();
		cadre.setPrefHeight(149.0);
		cadre.setPrefWidth(228.0);


		ImageView img = new ImageView(url);
		img.setPreserveRatio(true);
		img.setFitWidth(104.0);
		img.setFitHeight(99.0);
		cadre.setCenter(img);

		BorderPane buttons = new BorderPane();
		cadre.setBottom(buttons);

		Text title = new Text(name+"\n"+prix);
		title.setTextAlignment(TextAlignment.CENTER);
		buttons.setCenter(title);

		Button buttonLeft = new Button("-");
		buttonLeft.setAlignment(Pos.BASELINE_LEFT);
		buttons.setLeft(buttonLeft);
		Button buttonRight = new Button("+");
		buttonRight.setAlignment(Pos.BASELINE_RIGHT);
		buttons.setRight(buttonRight);

		return cadre;
	}
}
