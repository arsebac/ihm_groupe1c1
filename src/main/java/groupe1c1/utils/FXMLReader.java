package groupe1c1.utils;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe utilitaire
 *
 * @author François Melkonian
 */
public class FXMLReader {
	public static Stage createModifyItemWindow(Object controller) throws IOException {
		Stage subStage = new Stage();
		subStage.setTitle("Modifier un produit");
		FXMLLoader loader = new FXMLLoader();
		loader.setController(controller);
		VBox parent = loader.load(controller.getClass().getResourceAsStream("/fxml/modifyItem.fxml"));
		FlowPane root = new FlowPane();
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 330, 400);
		root.getChildren().add(parent);
		subStage.setScene(scene);
		subStage.show();
		return subStage;
	}
}
