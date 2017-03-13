package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import groupe1c1.model.data.Magasin;
import groupe1c1.utils.Reader;

import java.io.IOException;
import java.util.List;


/**
 * Created by DavidLANG on 03/03/2017.
 */
public class MagasinsDeserializer {

	public List<Magasin> deserialize() throws IOException {
		String jsonMagasin = new Reader().read("/magasin.json");

		if (jsonMagasin != null) {
			Gson gson = new Gson();
			return gson.fromJson(jsonMagasin, new TypeToken<List<Magasin>>() {
			}.getType());
		}
		return null;
	}

}
