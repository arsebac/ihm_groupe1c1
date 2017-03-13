package groupe1c1;

import groupe1c1.controller.MagasinsController;
import groupe1c1.controller.ProduitController;
import groupe1c1.controller.PromosController;
import groupe1c1.controller.TopController;
import groupe1c1.persistence.json.gson.EnseigneDeserializer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by DavidLANG on 13/03/2017.
 */
public class ClientEnseigne {

    private PromosController promosController;
    private TopController topController;

    public ClientEnseigne(Stage stage) throws IOException {
        VBox parent = new VBox();
        initParent(parent);
        ScrollPane scrollPane = new ScrollPane(parent);
        Scene scene = new Scene(scrollPane, 1210, 720);
        scene.getStylesheets().add("/styles/theme1.css");
        stage.setTitle("Hello JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        topController.registerParents(stage,parent);
        promosController.update();
    }

    private void initParent(VBox parent) throws IOException {
        parent.setSpacing(15);
        parent.getChildren().add(loadTop());
        parent.getChildren().add(new Separator());
        parent.getChildren().add(loadPromo());
        parent.getChildren().add(new Separator());
        parent.getChildren().add(loadProduitPhares());
        parent.getChildren().add(new Separator());
        parent.getChildren().add(loadMagasins());
    }



    private Node loadPromo() throws IOException {
        String fxmlFile = "/fxml/promo.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new PromosController());
        promosController = loader.getController();
        promosController.update();
        return loader.load(getClass().getResourceAsStream(fxmlFile));
    }

    private Node loadTop() throws IOException {
        String fxmlFile = "/fxml/haut.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new TopController());
        topController = loader.getController();
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
