package groupe1c1.controller;

import groupe1c1.model.Panier;
import groupe1c1.model.data.ItemPhare;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * @author user
 * @date 08/03/2017
 */
public class ItemController {

	@FXML
	private ImageView img;
	@FXML
	private Button minusB;
	@FXML
	private Button plusB;
	@FXML
	private Label name;
	@FXML
	private Label number;

	public void draw(ItemPhare item){
		img.setImage(new Image(item.getUrl()));
		//left.setOnMouseClicked(createListener(item,false));
		//right.setOnMouseClicked(createListener(item,true));
		name.setText(item.renderText());
		plusB.setOnMouseClicked(e-> Panier.addItem(item));
		minusB.setOnMouseClicked(e-> Panier.delItem(item));
	}

}
