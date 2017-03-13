package groupe1c1.controller.form;

import groupe1c1.controller.MagasinListViewCell;
import groupe1c1.model.MagasinModel;
import groupe1c1.model.data.Magasin;
import groupe1c1.persistence.json.gson.MagasinsSerializer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static groupe1c1.utils.ListUtils.initObservableList;

/**
 * Created by DavidLANG on 11/03/2017.
 */
public class GestionMagasins {

    @FXML
    private TextField filterTextField;

    @FXML
    private ListView<Magasin> magasinsListView;

    private List<Magasin> magasins;
    private ObservableList<Magasin> observableList;


    @FXML
    public void initialize() throws IOException {
        MagasinModel magasinModel = MagasinModel.getInstance();

        magasins = magasinModel.get();
        MagasinsSerializer magasinsSerializer = new MagasinsSerializer();
        magasinsSerializer.serialize(magasins);
        observableList = initObservableList(magasins);
        magasinsListView.setItems(observableList);
        magasinsListView.setCellFactory(magasinListView -> new MagasinListViewCell());
    }

    @FXML
    void addMagasin(ActionEvent event) throws IOException {
        ModifyAddMagasin modifyAddMagasin = new ModifyAddMagasin(null,  observableList, filterTextField);

    }

    @FXML
    void applyFilter(KeyEvent event) {
        String filter = filterTextField.getText();

        if (filter.matches("\\s*")) {
            if (observableList.size() != magasins.size())
                observableList.addAll(magasins);
        } else {
            observableList.removeAll(observableList);
            for (Magasin magasin : magasins) {
                if (magasin.getAdresse().contains(filter) || magasin.getName().contains(filter)) {
                    observableList.add(magasin);
                }
            }
        }
    }

    @FXML
    void deleteMagasin(ActionEvent event) {
        Magasin selectedMagasin = magasinsListView.getSelectionModel().getSelectedItem();

        if (selectedMagasin != null) {
            observableList.remove(selectedMagasin);
            magasins.remove(selectedMagasin);
        }
    }

    @FXML
    void modifyMagasin(ActionEvent event) throws IOException {
        Magasin selectedMagasin = magasinsListView.getSelectionModel().getSelectedItem();
        if (selectedMagasin != null)
            new ModifyAddMagasin(selectedMagasin, observableList,  filterTextField);
    }



}


