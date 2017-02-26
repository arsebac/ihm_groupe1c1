package groupe1c1.view;

import groupe1c1.ProduitPhareController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

/**
 * @author user
 * @date 26/02/2017
 */
public class ItemCategoryView {
	private final VBox parent;

	public ItemCategoryView(VBox parent) {
		this.parent = parent;
	}
	public void drawCategory(List<String> categoryNames, final ProduitPhareController controller){
		for (String name : categoryNames) {
			Label label = new Label(name);
			final String nameCat = name;
			label.setOnMouseClicked(event -> controller.detectClick(nameCat));
			label.setFont(new Font("System",35.0));
			label.setPrefSize(169.0,200.0);
			parent.getChildren().add(label);
		}
	}
}
