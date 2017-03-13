package groupe1c1.controller.stat;

import groupe1c1.model.StatModel;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.util.Map;

/**
 * @author user
 * @date 13/03/2017
 */
public class ReturnProduct {

	@FXML
	private LineChart<Number,Number> returnProduct;
	private StatModel model;

	@FXML
	public void initialize() throws IOException {
		model = new StatModel();
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		returnProduct = new LineChart<Number, Number>(xAxis, yAxis);
		createLineChartSeries();
	}

	private void createLineChartSeries(){
		for (Map.Entry<String ,Map<Integer,Integer>> entry:
				model.getReturnProduct().entrySet()) {
			XYChart.Series<Number, Number> serie = new XYChart.Series<>();
			serie.setName(entry.getKey());
			for (Map.Entry<Integer, Integer> graph :
					entry.getValue().entrySet()) {
				serie.getData().add(new XYChart.Data<>(graph.getKey(),graph.getValue()));
			}
			returnProduct.getData().add(serie);
		}
	}
}
