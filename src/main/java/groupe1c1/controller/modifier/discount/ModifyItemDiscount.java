package groupe1c1.controller.modifier.discount;

import groupe1c1.model.Promos;
import groupe1c1.model.data.ItemDiscount;
import groupe1c1.utils.LocatedImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 08/03/2017
 */
public class ModifyItemDiscount {

	private final Stage subStage;
	private ItemDiscount item;
	@FXML
	private ImageView image;
	@FXML
	private Button modifyImage;
	@FXML
	private TextField price;
	@FXML
	private TextField promotion;
	@FXML
	private TextField name;
	@FXML
	private Label priceText;

	public ModifyItemDiscount(ItemDiscount item) throws IOException {
		subStage = new Stage();
		subStage.setTitle("Modifier une promotion");
		String fxmlFile = "/fxml/modifyItem.fxml";
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
		FlowPane root = new FlowPane();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 330, 400);
		root.getChildren().add(parent);
		subStage.setScene(scene);
		subStage.show();
		this.item = item;
		updateView(item);

	}

	@FXML
	void modifyImage(MouseEvent event) {
		System.out.println("modifie le path de l'image");
	}

	@FXML
	void save(MouseEvent event) {
		String itemName = name.getText();
		double promo = (promotion.getText().length() > 0 ? Double.parseDouble(promotion.getText()) : 0.0);
		double prix = (price.getText().length() > 0 ? Double.parseDouble(price.getText()) : 0.0);
		String path = ((LocatedImage) image.getImage()).getUrl();
		ItemDiscount newItem = new ItemDiscount(itemName, prix, promo, path);
		subStage.close();
		Promos.updateItem(item, newItem);

	}

	public void updateView(ItemDiscount item) {
		LocatedImage img = LocatedImage.create(item.getUrl());
		image.setImage(img);
		name.setText(item.getName());
		price.setText(String.valueOf(item.getCost()));
		promotion.setText(String.valueOf(item.getDiscount()));

	}

}
