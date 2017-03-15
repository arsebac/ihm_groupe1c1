package groupe1c1;

import groupe1c1.controller.form.CreationEnseigne;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by DavidLANG on 13/03/2017.
 */
public class CreateEnseigne {
	public CreateEnseigne(Stage primaryStage) throws IOException {
		String fxmlFile = "/fxml/creerEnseigne.fxml";
		FXMLLoader loader = new FXMLLoader();
		CreationEnseigne enseigne = new CreationEnseigne();
		loader.setController(enseigne);
		VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
		TabPane tabPane = (TabPane) parent.getChildren().get(2);
		tabPane.getTabs().get(1).setContent(loadGestionMagasin());

		Scene scene = new Scene(parent, 1220, 863);
		scene.getStylesheets().add("/styles/theme1.css");
		primaryStage.setTitle("Création d'une enseigne");
		primaryStage.setScene(scene);
		primaryStage.show();
		enseigne.setStage(primaryStage);
	}

	private Node loadGestionMagasin() throws IOException {
		String fxmlFile = "/fxml/gestion-magasins.fxml";
		FXMLLoader loader = new FXMLLoader();
		return loader.load(getClass().getResourceAsStream(fxmlFile));
	}
}
