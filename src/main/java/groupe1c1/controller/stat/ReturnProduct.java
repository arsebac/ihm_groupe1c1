package groupe1c1.controller.stat;

import groupe1c1.model.StatModel;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.Map;

/**
 * Controlleur du graphique des produits retourné
 * Le graphique est présent dans une tabulation de la vue de modification de l'enseigne
 *
 * @author Francois Melkonian
 */
public class ReturnProduct {
	@FXML
	private StackedAreaChart<Number, Number> returnProduct;
	private StatModel model;

	@FXML
	public void initialize() throws IOException {
		model = new StatModel();
		createLineChartSeries();
	}

	/**
	 * Convertit les données sur les produits renvoyé du modèle en XYChart.Series pour être affichée.
	 * Les données sont initialement stocké dans un tableau qui associe le nom d'un magasin
	 * à un tableau qui à chaque jour associe le nombre de produits retournés
	 */
	private void createLineChartSeries() {
		for (Map.Entry<String, Map<Integer, Integer>> entry :
				model.getReturnProduct().entrySet()) {
			XYChart.Series<Number, Number> serie = new XYChart.Series<>();
			serie.setName(entry.getKey());
			for (Map.Entry<Integer, Integer> graph :
					entry.getValue().entrySet()) {
				serie.getData().add(new XYChart.Data<>(graph.getKey(), graph.getValue()));
			}
			returnProduct.getData().add(serie);
		}
	}
}
