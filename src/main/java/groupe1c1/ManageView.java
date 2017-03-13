package groupe1c1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class ManageView extends Application {

	private static final Logger log = LoggerFactory.getLogger(MainApp.class);

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		Parent parent =  loader.load(getClass().getResourceAsStream("/fxml/stat.fxml"));
		Scene scene = new Scene(parent, 1210, 720);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
