package groupe1c1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        log.info("Starting Hello JavaFX and Maven demonstration application");
        VBox parent = new VBox();
        parent.getChildren().add(loadTop());
        parent.getChildren().add(loadProduitPhares());
        parent.getChildren().add(loadMagasins());
        log.debug("Showing JFX scene");
	    ScrollPane scrollPane = new ScrollPane(parent);
	    Scene scene = new Scene(scrollPane, 1283, 720);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();

    }
    private Node loadTop() throws IOException {
        String fxmlFile = "/fxml/TOP.fxml";
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }
    private Node loadProduitPhares() throws IOException {
        String fxmlFile = "/fxml/produit.fxml";
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }
    private Node loadMagasins() throws IOException {
        String fxmlFile = "/fxml/magasin-vu-global.fxml";
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }
}
