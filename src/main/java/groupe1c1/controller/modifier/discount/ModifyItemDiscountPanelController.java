package groupe1c1.controller.modifier.discount;

import groupe1c1.controller.form.AfficheListViewCell;
import groupe1c1.controller.modifier.ProdPhareListViewCell;
import groupe1c1.model.ItemsDiscountManager;
import groupe1c1.model.ItemsPharesManager;
import groupe1c1.model.Promos;
import groupe1c1.model.data.ItemDiscount;
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
public class ModifyItemDiscountPanelController {
	private ObservableList<ItemDiscount> observableList;

	@FXML
	private ListView<ItemDiscount> listProd;

	@FXML
	private Text prodText;


	@FXML
	public void initialize() throws IOException {
		observableList =  ListUtils.initObservableList(Promos.getItemDiscount());

		listProd.setItems(observableList);
		listProd.setCellFactory(e -> new AfficheListViewCell());
		updateAfficheCounter();
	}

	@FXML
	void addButton(MouseEvent event) {
		ItemDiscount newItemDiscount = new ItemDiscount("Nouveau produit",0,0,"/images/produit1.png");
		observableList.add(newItemDiscount);
		Promos.addItem(newItemDiscount);
		updateItemDiscount(newItemDiscount);
		updateAfficheCounter();
	}
	@FXML
	void modifyButton(MouseEvent event) {
		if(listProd.getSelectionModel().getSelectedItem()!=null)
			updateItemDiscount(listProd.getSelectionModel().getSelectedItem());
	}
	private void updateItemDiscount(ItemDiscount itemToModify){
		try {
			new ModifyItemDiscount(itemToModify);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	void delButton(MouseEvent event) {
		ItemDiscount i = listProd.getSelectionModel().getSelectedItem();
		observableList.remove(i);
		ItemsPharesManager.remove(i);
		updateAfficheCounter();
	}
	public void updateAfficheCounter(){
		prodText.setText(observableList.size()+" produit"+(observableList.size() > 1 ? "s":""));
	}


}
