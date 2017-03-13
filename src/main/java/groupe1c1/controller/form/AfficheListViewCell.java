package groupe1c1.controller.form;

import groupe1c1.model.data.ItemDiscount;
import groupe1c1.utils.LocatedImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class AfficheListViewCell extends ListCell<ItemDiscount> {

	private FXMLLoader fxmlLoader;
	@FXML
	private ImageView image;

	@FXML
	private Text name;

	@FXML
	private BorderPane pane;

	public AfficheListViewCell() {

	}

	@Override
	protected void updateItem(ItemDiscount item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setGraphicAndText(null, null);
		} else {
			if (fxmlLoader == null) {
				try {
					fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/affiche.fxml"));
					fxmlLoader.setController(this);
					fxmlLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			setAttribute(item);
			setGraphicAndText(pane, null);
		}
	}
	private void setAttribute(ItemDiscount affiche){
		name.setText(affiche.getName());
		image.setImage(LocatedImage.create(affiche.getUrl()));
	}

	private void setGraphicAndText(Node graphic, String text) {
		setText(text);
		setGraphic(graphic);
	}
}
