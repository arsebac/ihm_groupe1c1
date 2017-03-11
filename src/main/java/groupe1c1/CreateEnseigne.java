package groupe1c1;/**
 * @author Hasaghi
 * @date 06/03/2017
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.io.InputStream;

public class CreateEnseigne extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{

		String fxmlFile = "/fxml/creerEnseigne.fxml";
		FXMLLoader loader = new FXMLLoader();
		VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
		parent.getChildren().add(loadGestionMagasin());
		Scene scene = new Scene(parent, 1210, 1032);
		scene.getStylesheets().add("/styles/styles.css");
		primaryStage.setTitle("Création d'une enseigne");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Node loadGestionMagasin() throws IOException {
		String fxmlFile = "/fxml/gestion-magasins.fxml";
		FXMLLoader loader = new FXMLLoader();
		return loader.load(getClass().getResourceAsStream(fxmlFile));
	}
}
