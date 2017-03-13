package groupe1c1.controller.modifier.phares;

import groupe1c1.controller.modifier.ModifyItemPanelController;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.utils.LocatedImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class ProdPhareListViewCell extends ListCell<ItemPhare> {

	private final ModifyItemPanelController enseigne;
	@FXML
	private ImageView img;
	@FXML
	private Label name;
	@FXML
	private Button plusB;
	@FXML
	private Button minusB;
	@FXML
	private BorderPane itemPane;
	private FXMLLoader fxmlLoader;

	@FXML
	private Label number;

	public ProdPhareListViewCell(ModifyItemPanelController enseigne) {
		this.enseigne = enseigne;
	}

	@Override
	protected void updateItem(ItemPhare item, boolean empty) {
		super.updateItem(item, empty);
		enseigne.updateProdCounter();
		if (empty || item == null) {
			setGraphicAndText(null, null);
		} else {
			if (fxmlLoader == null) {
				try {
					fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/itemphare.fxml"));
					fxmlLoader.setController(this);
					fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			setAttribute(item);
			setGraphicAndText(itemPane, null);
		}
	}

	private void setAttribute(ItemPhare item) {
		name.setText(item.getName() + "\n" + item.getCost() + "€");
		img.setImage(LocatedImage.create(item.getUrl()));
		plusB.setVisible(false);
		minusB.setVisible(false);
		number.setVisible(false);
	}

	private void setGraphicAndText(Node graphic, String text) {
		setText(text);
		setGraphic(graphic);
	}
}
