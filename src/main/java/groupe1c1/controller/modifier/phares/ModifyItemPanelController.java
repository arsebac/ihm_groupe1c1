package groupe1c1.controller.modifier.phares;

import groupe1c1.model.ItemsPharesManager;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.utils.ListUtils;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class ModifyItemPanelController {

	private ObservableList<ItemPhare> phareList;

	@FXML
	private ListView<ItemPhare> listPhare;


	@FXML
	private Text sprodText;

	@FXML
	public void initialize() throws IOException {

		phareList = ListUtils.initObservableList(ItemsPharesManager.getItemPhare());
		listPhare.setItems(phareList);
		listPhare.setCellFactory(e -> new ProdPhareListViewCell(this));
	}


	public void addProdButton(MouseEvent mouseEvent) {
		if (phareList.size() < 12) {
			ItemPhare newItem = new ItemPhare("Nouveau Produit", 0, "/images/tel.jpg");
			phareList.add(newItem);
			ItemsPharesManager.addItem(newItem);
			updateItem(newItem);
		} else System.out.println("Maximum atteint !");

	}

	public void modifyProdButton(MouseEvent mouseEvent) {
		ItemPhare itemToModify = listPhare.getSelectionModel().getSelectedItem();
		if (listPhare.getSelectionModel().getSelectedItem() == null) return;
		updateItem(itemToModify);

	}

	private void updateItem(ItemPhare item) {
		try {
			new ModifyItem(item, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ProddelButton(MouseEvent mouseEvent) {
		ItemPhare i = listPhare.getSelectionModel().getSelectedItem();
		phareList.remove(i);
		ItemsPharesManager.remove(i);

	}

	public void updateProdCounter() {
		sprodText.setText(phareList.size() + " produit" + (phareList.size() > 1 ? "s" : "") + " sur 12");
	}

	public void updateItem(ItemPhare oldItem, ItemPhare newItem) {
		int place = phareList.indexOf(oldItem);
		phareList.remove(oldItem);
		phareList.add(place, newItem);
		ItemsPharesManager.updateItem(oldItem, newItem);
	}
}
