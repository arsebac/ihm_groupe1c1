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

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        EnseigneDeserializer ens = new EnseigneDeserializer();
        log.info("Starting Hello JavaFX and Maven demonstration application");
        VBox parent = new VBox();
        parent.setSpacing(15);
        TopController tp = new TopController();
        parent.getChildren().add(loadTop(tp));

        parent.getChildren().add(new Separator());
        PromosController promoContro = new PromosController(ens);
        parent.getChildren().add(loadPromo(promoContro));
        parent.getChildren().add(new Separator());
        parent.getChildren().add(loadProduitPhares());
        parent.getChildren().add(new Separator());
        parent.getChildren().add(loadMagasins());
        log.debug("Showing JFX scene");
	    ScrollPane scrollPane = new ScrollPane(parent);
	    Scene scene = new Scene(scrollPane, 1210, 720);
        scene.getStylesheets().add("/styles/theme1.css");
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        tp.registerParents(stage,parent);
        promoContro.update();
    }

    private Node loadPromo(PromosController promoContro) throws IOException {
        String fxmlFile = "/fxml/promo.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setController(promoContro);
        promoContro.update();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }

    private Node loadTop(TopController tp) throws IOException {
        String fxmlFile = "/fxml/haut.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setController(tp);
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }
    private Node loadProduitPhares() throws IOException {
        String fxmlFile = "/fxml/produitContainer.fxml";
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }
    private Node loadMagasins() throws IOException {
        String fxmlFile = "/fxml/magasin-vu-global.fxml";
        FXMLLoader loader = new FXMLLoader();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }
}
