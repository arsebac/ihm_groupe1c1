package groupe1c1.controller.form;

import groupe1c1.MainApp;
import groupe1c1.model.LogoManager;
import groupe1c1.utils.LocatedImage;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class CreationEnseigne {


	@FXML
	private ImageView logoImg;
	private Stage stage;


	@FXML
	void modifyLogo(MouseEvent event) {
		System.out.println("logo changement");

	}

	private void updateImage(LocatedImage img) {
		logoImg.setImage(img);
	}


	@FXML
	public void initialize() throws IOException {
		updateImage(LogoManager.getImage());
	}

	@FXML
	void reload(MouseEvent event) throws Exception {
		new MainApp().start(stage);
	}


	public void setStage(Stage primaryStage) {
		this.stage = primaryStage;
	}
}
