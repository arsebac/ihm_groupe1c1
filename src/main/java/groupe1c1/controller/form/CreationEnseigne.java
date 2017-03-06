package groupe1c1.controller.form;

import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.model.data.LocatedImage;
import groupe1c1.model.parser.ItemParser;
import groupe1c1.persistence.json.gson.EnseigneSerializer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		observableList.add(new Affiche("produit "+ observableList.size(),"/images/produit1.png"));
	}
	@FXML
	void modifyButton(MouseEvent event) {
		System.out.println(listProd.getSelectionModel().getSelectedItem() + "sélectionné");
	}
	@FXML
	void delButton(MouseEvent event) {
		observableList.remove(listProd.getSelectionModel().getSelectedItem());
	}
	public void updateCounter(){
		prodText.setText(observableList.size()+" produit"+(observableList.size() > 1 ? "s":""));
	}

	//--------------- Logo ------------

	@FXML
	void modifyLogo(MouseEvent event) {
		System.out.println("logo changement");

	}
	void updateImage(LocatedImage img){
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
		observableList = FXCollections.observableArrayList();
		phareList =  FXCollections.observableArrayList();
		ItemParser parser = new ItemParser("/properties.json");
		for (int i = 0; i < parser.itemSize(); i++) {
			phareList.add(parser.getItem(i));
		}
		observableList.addAll(createFake());
		listProd.setItems(observableList);
		listPhare.setItems(phareList);
		listProd.setCellFactory(magasinListView -> new AfficheListViewCell(this));
		listPhare.setCellFactory(e -> new ProdPhareListViewCell(this));
		updateImage(LocatedImage.create("/images/logo.jpg"));

	}

	private List<Affiche> createFake() {
		List<Affiche> affiches = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			affiches.add(new Affiche("Produit "+i,"/images/produit"+(1+i%3)+".jpg"));
		}
		return affiches;
	}





	public void addProdButton(MouseEvent mouseEvent) {
		if(phareList.size() < 13)	phareList.add(new ItemPhare("produit "+ phareList.size(),13,"/images/tel.jpg"));
		else System.out.println("Maximum atteint !");

	}

	public void modifyProdButton(MouseEvent mouseEvent) {
		System.out.println(listPhare.getSelectionModel().getSelectedItem()+" sélectionné");
	}

	public void ProddelButton(MouseEvent mouseEvent) {
		System.out.println("suppresssion !");
		phareList.remove(listPhare.getSelectionModel().getSelectedItem());

	}
	public void updateProdCounter(){
		sprodText.setText(phareList.size()+" produit"+(phareList.size() > 1 ? "s":"")+" sur 12");
	}
}
