package groupe1c1.controller;

import groupe1c1.model.MagasinModel;
import groupe1c1.model.data.Magasin;
import groupe1c1.utils.ListUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
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
	public void initialize() throws IOException {
		MagasinModel magasinModel = MagasinModel.getInstance();

		magasins = magasinModel.get();
		toObserve = new ArrayList<>(magasins);
		observableList = ListUtils.initObservableList(toObserve);
		listViewMagasins.setItems(observableList);
		listViewMagasins.setCellFactory(magasinListView -> new MagasinListViewCell());
	}

	private ObservableList<Magasin> createObservableListMagasin(List<Magasin> magasins) {
		ObservableList<Magasin> magasinObservableList = FXCollections.observableArrayList();

		magasinObservableList.addAll(magasins);
		return magasinObservableList;
	}


	@FXML
	void appliquerFiltre(KeyEvent event) {
		String filter = textMagasin.getText();

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

}

