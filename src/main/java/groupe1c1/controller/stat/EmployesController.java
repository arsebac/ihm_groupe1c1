package groupe1c1.controller.stat;

import groupe1c1.model.StatModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.util.Map;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class EmployesController {
	private StatModel model;
	@FXML
	private PieChart employeChart;
	@FXML
	public void initialize() throws IOException {
		model = new StatModel();
		employeChart.setData(createEmployeChartData(model.getEmployesData()));
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
