package groupe1c1.controller;

import groupe1c1.model.data.Magasin;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by DavidLANG on 03/03/2017.
 */
public class MagasinListViewCell extends ListCell<Magasin> {

    private FXMLLoader fxmlLoader;

    @FXML
    ImageView image;

    @FXML
    Text name;

    @FXML
    Text centreCommercial;

    @FXML
    Text adresse;

    @FXML
    private Text telephone;

    @FXML
    private Text mail;

    @FXML
    private Text siteWeb;

    @FXML
    private Pane pane;

    @Override
    public void updateItem(Magasin magasin, boolean empty) {
        super.updateItem(magasin, empty);

        if (empty || magasin == null) {
            setGraphicAndText(null, null);
        } else {
            if (fxmlLoader == null) {
                this.initFXMLLoader();
            }

            setAttribute(magasin);
            setGraphicAndText(pane, null);
        }
    }


    private void setGraphicAndText(Node graphic, String text) {
        setText(text);
        setGraphic(graphic);
    }

    protected void setAttribute(Magasin magasin) {
        name.setText(magasin.getName());
        adresse.setText(magasin.getAdresse());
        centreCommercial.setText(magasin.getCentreCommercial());
        telephone.setText(magasin.getTelephone());
        mail.setText(magasin.getMail());
        siteWeb.setText(magasin.getSiteWeb());
        image.setImage(new Image("/images/magasin.png"));
    }


    protected void initFXMLLoader() {
        initFXMLLoader("/fxml/magasin.fxml");
    }

    void initFXMLLoader(String filename) {
        fxmlLoader = new FXMLLoader(getClass().getResource(filename));
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
