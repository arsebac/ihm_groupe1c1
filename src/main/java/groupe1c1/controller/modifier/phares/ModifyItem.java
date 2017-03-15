package groupe1c1.controller.modifier.phares;

import groupe1c1.model.data.ItemPhare;
import groupe1c1.utils.FXMLReader;
import groupe1c1.utils.LocatedImage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 08/03/2017
 */
public class ModifyItem {

	private final Stage subStage;
	private final ModifyItemPanelController parentController;
	private ItemPhare item;
	@FXML
	private ImageView image;
	@FXML
	private Button modifyImage;
	@FXML
	private TextField price;
	@FXML
	private TextField name;

	public ModifyItem(ItemPhare item, ModifyItemPanelController modifyItemPanelController) throws IOException {
		subStage = FXMLReader.createModifyItemWindow(this);
		this.item = item;
		updateView(item);
		this.parentController = modifyItemPanelController;

	}

	@FXML
	void modifyImage(MouseEvent event) {
		System.out.println("modifie le path de l'image");
	}

	@FXML
	void save(MouseEvent event) {
		double prix = (price.getText().length() > 0 ? Double.parseDouble(price.getText()) : 0.0);
		String itemName = name.getText();
		String path = ((LocatedImage) image.getImage()).getUrl();
		ItemPhare newItem = new ItemPhare(itemName, prix, path);
		subStage.close();
		parentController.updateItem(item, newItem);

	}

	public void updateView(ItemPhare item) {
		LocatedImage img = LocatedImage.create(item.getUrl());
		image.setImage(img);
		name.setText(item.getName());
		price.setText(String.valueOf(item.getCost()));

	}
}
