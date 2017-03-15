package groupe1c1.controller;

import groupe1c1.model.data.Magasin;
import javafx.scene.image.Image;

/**
 * @author user
 * @date 11/03/2017
 */
public class MinimalMagasinListViewCell extends MagasinListViewCell {
	@Override
	public void setAttribute(Magasin magasin) {
		name.setText(magasin.getName());
		adresse.setText(magasin.getAdresse());
		centreCommercial.setText(magasin.getCentreCommercial());
		image.setImage(new Image(magasin.getPathImage()));
	}

	@Override
	protected void initFXMLLoader() {
		initFXMLLoader("/fxml/smart-magasin.fxml");
	}
}
