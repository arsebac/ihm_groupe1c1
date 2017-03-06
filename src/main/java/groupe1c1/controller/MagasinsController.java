package groupe1c1.controller;

import groupe1c1.model.data.Magasin;
import groupe1c1.model.MagasinModel;
import groupe1c1.persistence.json.gson.MagasinsSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class MagasinsController {

    @FXML
    private ListView<Magasin> listViewMagasins;

    @FXML
    private TextField textMagasin;

    @FXML
    private Button buttonAppliquer;

    private List<Magasin> magasins;
    private List<Magasin> toObserve;
    private ObservableList<Magasin> observableList;

    @FXML
    public void initialize() {
        MagasinModel magasinModel = new MagasinModel();

        magasins = magasinModel.get();
        toObserve = new ArrayList<>(magasins);
        MagasinsSerializer magasinsSerializer = new MagasinsSerializer();
        magasinsSerializer.serialize(magasins);
        observableList = createObservableListMagasin(toObserve);
        listViewMagasins.setItems(observableList);
        listViewMagasins.setCellFactory(magasinListView -> new MagasinListViewCell());
    }

    private ObservableList<Magasin> createObservableListMagasin(List<Magasin> magasins) {
        ObservableList<Magasin> magasinObservableList = FXCollections.observableArrayList();

        magasinObservableList.addAll(magasins);
        return magasinObservableList;
    }


    @FXML
    void appliquerFiltre(MouseEvent event) {
        String filter = textMagasin.getText();

        if (filter.matches("\\s*")) {
            observableList.addAll(magasins);
        } else {
            observableList.removeAll(observableList);
            for (Magasin magasin : magasins) {
                if (magasin.getAdresse().contains(filter) || magasin.getName().matches(filter)) {
                    observableList.add(magasin);
                }
            }
        }
    }

}

