package groupe1c1.controller;

import groupe1c1.model.Panier;
import groupe1c1.model.Promos;
import groupe1c1.model.data.Affiche;
import groupe1c1.persistence.json.gson.EnseigneDeserializer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * @author user
 * @date 08/03/2017
 */
public class PromosController {
	private final Promos promos;
	@FXML  private ImageView img0;
	@FXML  private ImageView imgpd;
	@FXML  private ImageView img2;
	@FXML  private ImageView img3;
	@FXML  private Button buy0;
	@FXML  private Button buy1;
	@FXML  private Button buy2;
	@FXML  private Button buy3;


	@FXML void buy0(MouseEvent event) {
		Affiche aff = promos.getNiemeAffiche(0);
		Panier.addItem(aff);
	}
	@FXML void buy1(MouseEvent event) {

		Affiche aff = promos.getNiemeAffiche(1);
		Panier.addItem(aff);
	}
	@FXML void buy2(MouseEvent event) {

		Affiche aff = promos.getNiemeAffiche(2);
		Panier.addItem(aff);
	}
	@FXML void buy3(MouseEvent event) {

		Affiche aff = promos.getNiemeAffiche(3);
		Panier.addItem(aff);
	}
	@FXML void leftButton(MouseEvent event) {
		promos.left();
		update();
	}
	@FXML void rightButton(MouseEvent event) {

		promos.right();
		update();
	}

	public PromosController(EnseigneDeserializer enseigne) {
		System.out.println("yolo");
		this.promos = new Promos(enseigne);
		//update();

	}
	public void update(){
		if(img0 != null){
			update(promos.getNiemeAffiche(0),img0,buy0);
			update(promos.getNiemeAffiche(1),imgpd,buy1);
			update(promos.getNiemeAffiche(2),img2,buy2);
			update(promos.getNiemeAffiche(3),img3,buy3);
		}
	}

	public void update(Affiche aff,ImageView img,Button but){
		img.setImage(new Image(aff.getPath()));
		but.setText("Acheter "+aff.getName());
	}
}
