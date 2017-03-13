package groupe1c1;

import groupe1c1.controller.PromosController;
import groupe1c1.controller.TopController;
import groupe1c1.persistence.json.gson.EnseigneDeserializer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        CreateEnseigne createEnseigne = new CreateEnseigne(new Stage());
        ClientEnseigne clientEnseigne = new ClientEnseigne(stage);
    }

}
