package groupe1c1.controller.form;

import groupe1c1.model.data.Magasin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by DavidLANG on 11/03/2017.
 */
public class ModifyAddMagasin {

    @FXML
    private Text title;

    @FXML
    private ImageView preview;

    @FXML
    private TextField name;

    @FXML
    private TextField centreCommercial;

    @FXML
    private TextField adresse;

    @FXML
    private TextField telephone;

    @FXML
    private TextField mail;

    @FXML
    private TextField siteWeb;

    @FXML
    private Button btModify;

    private final Stage subStage;
    private Magasin magasin;
    private FileChooser fileChooser;

    public ModifyAddMagasin(Magasin magasin) throws IOException {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Choisir une image");
        subStage = new Stage();
        this.magasin = magasin;
        init();
        if (magasin == null)
            initAdd();
        else
            initModify(magasin);
    }

    private void initAdd() {
        title.setText("Ajouter un magasin");
        btModify.setText("Ajouter");
    }

    private void initModify(Magasin magasin) {
        title.setText("Modifier un magasin");
        btModify.setText("Modifier");
        mail.setText(magasin.getMail());
        adresse.setText(magasin.getAdresse());
        centreCommercial.setText(magasin.getCentreCommercial());
        name.setText(magasin.getName());
        siteWeb.setText(magasin.getSiteWeb());
        telephone.setText(magasin.getTelephone());
    }

    private void init() throws IOException {
        subStage.setTitle("Modifier un magasin");
        String fxmlFile = "/fxml/modifyMagasin.fxml";
        FXMLLoader loader = new FXMLLoader();
        loader.setController(this);
        VBox parent = loader.load(getClass().getResourceAsStream(fxmlFile));
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 352, 525);
        root.getChildren().add(parent);
        subStage.setScene(scene);
        subStage.show();
        setBtModifyHandler();
    }

    @FXML
    void modifyImage(ActionEvent event) {
        fileChooser.showOpenDialog(subStage);
    }

    private void setBtModifyHandler() {
        btModify.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                subStage.close();
            }
        });
    }

}
