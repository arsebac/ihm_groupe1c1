package groupe1c1.controller.form;

import groupe1c1.CreateEnseigne;
import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.LocatedImage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class AfficheListViewCell extends ListCell<Affiche> {

	private final CreationEnseigne enseigne;
	private FXMLLoader fxmlLoader;
	@FXML
	private ImageView image;

	@FXML
	private Text name;

	@FXML
	private BorderPane pane;

	public AfficheListViewCell(CreationEnseigne enseigne) {
		this.enseigne = enseigne;

	}

	@Override
	protected void updateItem(Affiche item, boolean empty) {
		super.updateItem(item, empty);
		enseigne.updateCounter();
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
	private void setAttribute(Affiche affiche){
		name.setText(affiche.getName());
		image.setImage(LocatedImage.create(affiche.getPath()));
	}

	private void setGraphicAndText(Node graphic, String text) {
		setText(text);
		setGraphic(graphic);
	}
}
