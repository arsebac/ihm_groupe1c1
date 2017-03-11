package groupe1c1.controller;

import groupe1c1.model.Panier;
import groupe1c1.model.data.ItemPhare;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

/**
 * @author Hasaghi
 * @date 11/03/2017
 */
public class TopController {
	@FXML
	private HBox topContainer;
	@FXML
	private AnchorPane anchorPanier;
	@FXML
	private Label total;
	@FXML
	private VBox panierList;
	@FXML
	private Button panierButton;

	@FXML
	private ListView<String> panierItemList;
	@FXML
	private ListView<String> priceList;

	@FXML
	void commandButton(MouseEvent event) {
		System.out.println("Veuillez choisir le magasin dans lequel vous souhaitez retirer votre commande");
	}

	private boolean hidden;

	@FXML
	void panier(MouseEvent event) {
		show();

	}


	private void show() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setController(this);
			Parent root = loader.load(getClass().getResourceAsStream("/fxml/panier.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Mon panier");
			stage.setScene(new Scene(root, 385, 387));
			drawPanier();
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void drawPanier() {
		panierList.getChildren().clear();
		for (Map.Entry<ItemPhare, Integer> item : Panier.getItems()){
			String name = item.getKey().getName()+"\t\t";
			if(item.getValue() != 1) name = item.getValue() + " x " + name;
			Label itemName = new Label(name);
			itemName.setPrefSize(150,25);
			Label costLabel = new Label(Panier.getItemsPrice(item.getKey()));
			costLabel.setPrefSize(50,25);
			HBox container = new HBox(itemName,costLabel);
			panierList.getChildren().add(container);
		}
		total.setText(Panier.getTotalPrice()+" €");

	}

}
