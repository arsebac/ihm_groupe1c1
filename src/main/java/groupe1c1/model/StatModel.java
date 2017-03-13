package groupe1c1.model;

import groupe1c1.model.data.MagasinInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class StatModel {

	private List<MagasinInformation> data;

	public StatModel() {
		data = createSampleData();
	}

	private List<MagasinInformation> createSampleData() {
		List<MagasinInformation> magasins = new ArrayList<>();
		magasins.add(new MagasinInformation("Carrefour Nice", 100000, 25, 40));
		magasins.add(new MagasinInformation("Librairie Nice", 60000, 40, 20));
		magasins.add(new MagasinInformation("Carrefour Antibes", 110000, 50, 60));
		return magasins;
	}

	public Map<String, Number> getCa() {
		Map<String, Number> ca = new HashMap<>();
		for (MagasinInformation magasin :
				data) {
			ca.put(magasin.getName(), magasin.getCa());
		}
		return ca;
	}

	public Map<String, Map<Integer, Integer>> getReturnProduct() {
		Map<String, Map<Integer, Integer>> returnProd = new HashMap<>();
		for (MagasinInformation magasin :
				data) {
			returnProd.put(magasin.getName(), magasin.getProductPerDay());
		}
		return returnProd;
	}

	public Map<String, Integer> getEmployesData() {
		Map<String, Integer> returnProd = new HashMap<>();
		for (MagasinInformation magasin :
				data) {
			returnProd.put(magasin.getName() + " - " + magasin.getNbEmploye(), magasin.getNbEmploye());
		}
		return returnProd;
	}
}
