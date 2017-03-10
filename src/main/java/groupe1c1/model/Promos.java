package groupe1c1.model;

import groupe1c1.model.data.Affiche;
import groupe1c1.persistence.json.gson.EnseigneDeserializer;

import java.util.List;

/**
 * @author user
 * @date 08/03/2017
 */
public class Promos {
	private List<Affiche> affiches;
	private EnseigneDeserializer data;
	private int start;
	public Promos(EnseigneDeserializer data) {
		start = 0;
		this.affiches = data.getAffiches();
		this.data = data;
	}
	public List<Affiche> getPromos(){
		return affiches.subList(start,Math.min(3 + start, affiches.size()));
	}
	public Affiche getNiemeAffiche(int n){
		return affiches.get(start+ n);
	}

	public void left() {
		if(start > 0) start --;
	}
	public void right() {
		if(start <affiches.size() - 1) start ++;
	}
}
