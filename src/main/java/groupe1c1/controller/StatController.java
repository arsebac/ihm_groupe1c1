package groupe1c1.controller;

import groupe1c1.model.StatModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class StatController {
	private StatModel model;
	@FXML
	private BarChart<String,Number> caChart;
	@FXML
	private PieChart employeChart;
	@FXML
	private LineChart<Number,Number> returnProduct;
	@FXML
	public void initialize() throws IOException {
		model = new StatModel();

		final CategoryAxis x = new CategoryAxis();
		x.setLabel("Chiffre d'affaire sur les 12 derniers mois");
		final NumberAxis y = new NumberAxis();
		y.setLabel("Magasins");
		caChart.getData().add(displayCa(model.getCa()));
		employeChart.setData(createEmployeChartData(model.getEmployesData()));

		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		returnProduct =new LineChart<Number,Number>(xAxis,yAxis);
		createLineChartSeries();


	}
	private void createLineChartSeries(){
		for (Map.Entry<String ,Map<Integer,Integer>> entry:
				model.getReturnProduct().entrySet()) {
			XYChart.Series serie = new XYChart.Series<>();
			System.out.println(entry);
			serie.setName(entry.getKey());
			for (Map.Entry<Integer, Integer> graph :
					entry.getValue().entrySet()) {
				serie.getData().add(new XYChart.Data<>(graph.getKey(),graph.getValue()));
				System.out.println(graph);
			}
			returnProduct.getData().add(serie);
		}
	}
	private  XYChart.Series<String,Number> displayCa(Map<String, Number> mag){
		XYChart.Series<String,Number> series = new XYChart.Series<>();
		for (Map.Entry<String ,Number> entry:
		mag.entrySet()) {
			System.out.println(entry);
			series.getData().add(new XYChart.Data<String,Number>(entry.getKey(),entry.getValue()));
		}
		return series;
	}

	private ObservableList<PieChart.Data> createEmployeChartData(Map<String, Integer> mag) {
		ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
		for (Map.Entry<String ,Integer> entry:
				mag.entrySet()) {
			PieChart.Data dataTemp = new PieChart.Data(entry.getKey(),entry.getValue());
			pieChartData.addAll(dataTemp);
		}
		return pieChartData;
	}

}
