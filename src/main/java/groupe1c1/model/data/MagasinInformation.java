package groupe1c1.model.data;

import java.util.*;

/**
 * @author Hasaghi
 * @date 13/03/2017
 */
public class MagasinInformation {
	private final  String name;
	private final double ca;
	private final int prodRenvoye;
	private List<Integer> returnProductDays;
	private Map<Integer,Integer> productPerDay;
	private  final int nbEmploye;

	public MagasinInformation(String name,double ca, int prodRenvoye, int nbEmploye) {
		this.name = name;
		this.ca = ca;
		this.prodRenvoye = prodRenvoye;
		this.nbEmploye = nbEmploye;
		createProdRenvoye();
	}

	private void createProdRenvoye() {
		returnProductDays = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < prodRenvoye; i++) {
			returnProductDays.add(random.nextInt(30));
		}
		productPerDay = new HashMap<>();
		for (int i = 0; i < 30; i++) {
			int finalI = i;
			int nb = Math.toIntExact( returnProductDays.stream().filter(integer -> integer.equals(finalI)).count());
			productPerDay.put(i,nb);
		}
	}

	public String getName() {
		return name;
	}

	public double getCa() {
		return ca;
	}

	public int getProdRenvoye() {
		return prodRenvoye;
	}

	public int getNbEmploye() {
		return nbEmploye;
	}

	public Map<Integer, Integer> getProductPerDay() {
		return productPerDay;
	}
}
