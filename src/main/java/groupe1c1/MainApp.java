package groupe1c1;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) throws Exception {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		CreateEnseigne createEnseigne = new CreateEnseigne(new Stage());
		ClientEnseigne clientEnseigne = new ClientEnseigne(stage);
	}

}
