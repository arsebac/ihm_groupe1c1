package groupe1c1.model;

import groupe1c1.model.data.Magasin;
import groupe1c1.persistence.json.gson.MagasinsDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DavidLANG on 01/03/2017.
 */
public class MagasinModel {

	private static MagasinModel INSTANCE = null;
	List<Magasin> magasins = new ArrayList<>();

	private MagasinModel() throws IOException {
		MagasinsDeserializer magasinsDeserializer = new MagasinsDeserializer();
		magasins = magasinsDeserializer.deserialize();
	}


	static public MagasinModel getInstance() throws IOException {
		if (INSTANCE == null)
			INSTANCE = new MagasinModel();
		return INSTANCE;
	}

	public void add(Magasin magasin) {
		magasins.add(magasin);
	}

	public List<Magasin> get() {
		return magasins;
	}

}
