package groupe1c1.controller;

import groupe1c1.ClientEnseigne;
import groupe1c1.CreateEnseigne;
import groupe1c1.model.MagasinModel;
import groupe1c1.model.Panier;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.model.data.Magasin;
import groupe1c1.utils.ListUtils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

/**
 * @author Hasaghi
 * @date 11/03/2017
 */
public class TopController {
    private Stage panierStage = null;
    private ObservableList<Magasin> observableList;
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

    private boolean info = false;

    @FXML
    private ListView<Magasin> magasinsListView;
    private Stage mainStage = null;
    private Parent parent;
    private boolean principal = true;

    @FXML
    void finaliseCommand(MouseEvent event) {
        Magasin chosen = magasinsListView.getSelectionModel().getSelectedItem();
        if (chosen != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Votre commande n°12 a été enregistré ! Elle sera envoyé sous 5 jours ouvrés à l'adresse :\n\n" + chosen.getAdresse() + ".\n\nVous pouvez appeler le " + chosen.getTelephone() + " pour suivre l'avancement de votre colis.");
            alert.setHeaderText("Commande n°12 enregistrée !");
            alert.showAndWait();
            panierStage.close();
        }

    }

    @FXML
    public void refresh() throws Exception {
        Panier.resetPanier();
    }

    @FXML
    public void connection() throws IOException {
        new CreateEnseigne(mainStage);
    }

    @FXML
    void commandButton(MouseEvent event) throws IOException {
        panierStage.close();
        observableList = ListUtils.initObservableList(MagasinModel.getInstance().get());
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(this);
            Parent root = loader.load(getClass().getResourceAsStream("/fxml/magasinSelector.fxml"));
            magasinsListView.setItems(observableList);
            magasinsListView.setCellFactory(magasinListView -> new MinimalMagasinListViewCell());
            panierStage = new Stage();
            panierStage.setTitle("Mon panier");
            panierStage.setScene(new Scene(root, 385, 387));
            panierStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void panier(MouseEvent event) {
        show();
    }

    private void show() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(this);
            Parent root = loader.load(getClass().getResourceAsStream("/fxml/panier.fxml"));
            panierStage = new Stage();
            panierStage.setTitle("Mon panier");
            panierStage.setScene(new Scene(root, 385, 387));
            drawPanier();
            panierStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void drawPanier() {
        panierList.getChildren().clear();
        for (Map.Entry<ItemPhare, Integer> item : Panier.getItems()) {
            String name = item.getKey().getName();
            if (item.getValue() != 1) name = item.getValue() + " x " + name;
            Label itemName = new Label(name);
            itemName.setPrefSize(150, 25);
            Label costLabel = new Label(Panier.getItemsPrice(item.getKey()));
            costLabel.setPrefSize(50, 25);
            HBox container = new HBox(itemName, costLabel);
            panierList.getChildren().add(container);
        }
        total.setText(Panier.getTotalPrice() + " €");

    }

    public void backPrincipal() throws IOException {
        new ClientEnseigne(mainStage);
    }

    public void registerParents(Stage stage, Parent parent) {
        this.mainStage = stage;
        this.parent = parent;
    }

    public void informations() throws IOException {
        if (!info) {
            ((VBox) parent).getChildren().remove(1);
            ((VBox) parent).getChildren().remove(1);
            ((VBox) parent).getChildren().remove(1);
            ((VBox) parent).getChildren().remove(1);
            ((VBox) parent).getChildren().remove(1);
            ((VBox) parent).getChildren().remove(1);
            ((VBox) parent).getChildren().add(new Separator());
            ((VBox) parent).getChildren().add(loadInformations());
            info = true;
        }
    }

    private Node loadInformations() throws IOException {
        String chemin = "/fxml/informations.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        return fxmlLoader.load(getClass().getResourceAsStream(chemin));
    }
}
