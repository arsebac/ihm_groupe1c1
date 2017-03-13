package groupe1c1.controller.form;

import groupe1c1.model.MagasinModel;
import groupe1c1.model.data.Magasin;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

import java.io.IOException;

/**
 * Created by DavidLANG on 11/03/2017.
 */
public class ModifyAddMagasin {

	private final Stage subStage;
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
	private Magasin magasin;
	private FileChooser fileChooser;

	// TO UPDATE
	private TextField textField;
	private ObservableList<Magasin> observableList;

	public ModifyAddMagasin(Magasin magasin, ObservableList observableList, TextField textField) throws IOException {
		this.textField = textField;
		this.observableList = observableList;
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

	private void add(Magasin magasin) throws IOException {
		MagasinModel.getInstance().add(magasin);
		observableList.add(magasin);
	}

	private void update() {

	}


	private void setBtModifyHandler() {
		btModify.setOnMouseClicked(event -> {
			String textName = name.getText();
			String textCentreCommercial = centreCommercial.getText();
			String textAdresse = adresse.getText();
			String textTelephone = telephone.getText();
			String textMail = mail.getText();
			String textSiteWeb = siteWeb.getText();

			if (!(textName.isEmpty() && textCentreCommercial.isEmpty() && textAdresse.isEmpty() && textTelephone.isEmpty()
					&& textMail.isEmpty() && textSiteWeb.isEmpty())) {
				if (magasin == null) {
					try {
						add(new Magasin(textName, "", textCentreCommercial, textAdresse, textTelephone, textMail, textSiteWeb));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					magasin.setAdresse(textAdresse);
					magasin.setCentreCommercial(textCentreCommercial);
					magasin.setMail(textMail);
					magasin.setName(textName);
					magasin.setPathImage("");
					magasin.setSiteWeb(textSiteWeb);
					magasin.setTelephone(textTelephone);
					observableList.set(observableList.indexOf(magasin), magasin);
				}

				textField.setText("");
				subStage.close();
			}
		});
	}

}
