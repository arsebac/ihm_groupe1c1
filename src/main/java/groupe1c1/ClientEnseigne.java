package groupe1c1;

import groupe1c1.controller.TopController;
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
 *
 * @author Francois Melkonian
 */
public class ClientEnseigne {

	private TopController topController;

	public ClientEnseigne(Stage stage) throws IOException {
		VBox parent = new VBox();
		initParent(parent);
		ScrollPane scrollPane = new ScrollPane(parent);
		Scene scene = new Scene(scrollPane, 1210, 720);
		scene.getStylesheets().add("/styles/theme1.css");
		stage.setTitle("To be or to have");
		stage.setScene(scene);
		stage.show();
		topController.registerParents(stage, parent);
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
