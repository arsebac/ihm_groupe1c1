package groupe1c1.controller.form;

import groupe1c1.model.data.Affiche;
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
public class ModifyAffiche {

		private final Stage subStage;
		private Affiche item;
		@FXML
		private ImageView image;
		@FXML
		private Button modifyImage;
		@FXML
		private TextField price;
	@FXML
	private TextField name;
	@FXML
	private Label priceText;
		@FXML
		void modifyImage(MouseEvent event) {
			System.out.println("modifie le path de l'image");
		}

		@FXML
		void save(MouseEvent event) {
			String itemName = name.getText();
			String path = ((LocatedImage) image.getImage()).getUrl();
			Affiche newItem = new Affiche(itemName,path);
			subStage.close();
			enseigne.updateAffiche(item,newItem);

		}
		private CreationEnseigne enseigne;

		public ModifyAffiche(CreationEnseigne enseigne, Affiche item) throws IOException {
			subStage = new Stage();
			subStage.setTitle("Modifier une affiche");
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
			price.setVisible(false);
			priceText.setVisible(false);
			this.enseigne = enseigne;
			this.item = item;
			updateView(item);

		}
		public void updateView(Affiche item){
			LocatedImage img = LocatedImage.create(item.getPath());
			image.setImage(img);
			name.setText(item.getName());

		}

}
