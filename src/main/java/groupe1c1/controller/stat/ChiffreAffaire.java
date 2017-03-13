package groupe1c1.controller.stat;

import groupe1c1.model.StatModel;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.Map;

/**
 * @author user
 * @date 13/03/2017
 */
public class ChiffreAffaire {

	private StatModel model;
	@FXML
	private BarChart<String, Number> caChart;


	@FXML
	public void initialize() throws IOException {
		model = new StatModel();
		final CategoryAxis x = new CategoryAxis();
		x.setLabel("Chiffre d'affaire sur les 12 derniers mois");
		final NumberAxis y = new NumberAxis();
		y.setLabel("Magasins");
		caChart.getData().add(displayCa(model.getCa()));
	}

	private XYChart.Series<String, Number> displayCa(Map<String, Number> mag) {
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		for (Map.Entry<String, Number> entry :
				mag.entrySet()) {
			series.getData().add(new XYChart.Data<String, Number>(entry.getKey(), entry.getValue()));
		}
		return series;
	}
}

