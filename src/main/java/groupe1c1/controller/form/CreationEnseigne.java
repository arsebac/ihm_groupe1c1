package groupe1c1.controller.form;

import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.utils.LocatedImage;
import groupe1c1.persistence.json.gson.EnseigneDeserializer;
import groupe1c1.persistence.json.gson.EnseigneSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class CreationEnseigne {
	private ObservableList<Affiche> observableList;
	private ObservableList<ItemPhare> phareList;

	@FXML
	private ListView<Affiche> listProd;
	@FXML
	private ListView<ItemPhare> listPhare;

	@FXML
	private Text prodText;
	@FXML
	private Text sprodText;
	@FXML
	private ImageView logoImg;

	// ------------ Partie sur la liste d'affiches ------------------
	@FXML
	void addButton(MouseEvent event) {
		Affiche newAffiche = new Affiche("Nouveau produit","/images/produit1.png");
		observableList.add(newAffiche);
		updateAffiche(newAffiche);
	}
	@FXML
	void modifyButton(MouseEvent event) {
		System.out.println(listProd.getSelectionModel().getSelectedItem() + "sélectionné");
		updateAffiche(listProd.getSelectionModel().getSelectedItem());
	}
	private void updateAffiche(Affiche afficheToModify){
		try {
			new ModifyAffiche(this,afficheToModify);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	void delButton(MouseEvent event) {
		observableList.remove(listProd.getSelectionModel().getSelectedItem());
	}
	public void updateAfficheCounter(){
		prodText.setText(observableList.size()+" produit"+(observableList.size() > 1 ? "s":""));
	}

	//--------------- Logo ------------

	@FXML
	void modifyLogo(MouseEvent event) {
		System.out.println("logo changement");

	}
	private void updateImage(LocatedImage img){
		logoImg.setImage(img);
	}



	@FXML
	void save(MouseEvent event) {
		EnseigneSerializer e = new EnseigneSerializer();
		try {
			e.serialize(observableList,phareList, (LocatedImage) logoImg.getImage());
		} catch (IOException e1) {
			System.out.println("impossible de sauvegarder");
			e1.printStackTrace();
		}

	}



	@FXML
	public void initialize() throws IOException {
		EnseigneDeserializer model = new EnseigneDeserializer();
		LocatedImage logo = LocatedImage.create(model.getLogoPath());
		updateImage(logo);
		observableList = FXCollections.observableArrayList();
		observableList.addAll(model.getAffiches());
		phareList =  FXCollections.observableArrayList();
		phareList.addAll(model.getItems());
		listProd.setItems(observableList);
		listPhare.setItems(phareList);
		listProd.setCellFactory(magasinListView -> new AfficheListViewCell(this));
		listPhare.setCellFactory(e -> new ProdPhareListViewCell(this));
		updateImage(LocatedImage.create("/images/logo.jpg"));

	}

	public void addProdButton(MouseEvent mouseEvent) {
		if(phareList.size() < 12)	phareList.add(new ItemPhare("produit "+ phareList.size(),13,"/images/tel.jpg"));
		else System.out.println("Maximum atteint !");

	}

	public void modifyProdButton(MouseEvent mouseEvent) {
		ItemPhare itemToModify = listPhare.getSelectionModel().getSelectedItem();
		try {
			new ModifyItem(this,itemToModify);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void ProddelButton(MouseEvent mouseEvent) {
		System.out.println("suppresssion !");
		phareList.remove(listPhare.getSelectionModel().getSelectedItem());

	}
	public void updateProdCounter(){
		sprodText.setText(phareList.size()+" produit"+(phareList.size() > 1 ? "s":"")+" sur 12");
	}

	public void updateItem(ItemPhare oldItem, ItemPhare newItem) {
		int place = phareList.indexOf(oldItem);
		phareList.remove(oldItem);
		phareList.add(place, newItem);
	}

	public void updateAffiche(Affiche item, Affiche newItem) {
		int place = observableList.indexOf(item);
		observableList.remove(item);
		observableList.add(place, newItem);
	}
}
