package groupe1c1;/**
 * @author Hasaghi
 * @date 06/03/2017
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CreateEnseigne extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{

		String fxmlFile = "/fxml/creerEnseigne.fxml";
		FXMLLoader loader = new FXMLLoader();
		VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
		Scene scene = new Scene(parent, 1210, 720);
		scene.getStylesheets().add("/styles/styles.css");
		primaryStage.setTitle("Hello JavaFX and Maven");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
