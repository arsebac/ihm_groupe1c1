package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import groupe1c1.CreateEnseigne;
import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.model.data.LocatedImage;
import groupe1c1.model.data.Magasin;
import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.util.List;

/**
 * @author Hasaghi
 * @date 06/03/2017
 */
public class EnseigneSerializer {
	private final static String FILENAME = "/properties.json";
	public void serialize(List<Affiche> affiches, List<ItemPhare> items, LocatedImage imageURL) throws IOException {
		Gson gson = new Gson();
		JSONArray mags =  new JSONArray(gson.toJson(affiches));
		JSONArray itemsJson =  new JSONArray(gson.toJson(items));
		JSONObject total = new JSONObject();
		total.put("affiches",mags);
		total.put("items",itemsJson);
		total.put("logo",imageURL.getUrl());

		System.out.println(total.toString());
	}
}
