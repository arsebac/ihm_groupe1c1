package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import groupe1c1.model.data.ItemDiscount;
import groupe1c1.model.data.ItemPhare;
import groupe1c1.utils.Reader;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hasaghi
 * @date 08/03/2017
 */
public class EnseigneDeserializer {
	private final static String FILENAME = "/properties.json";
	private JSONObject data;
	private Gson gson;

	public EnseigneDeserializer() throws IOException {
		String source = new Reader().read(FILENAME);
		data = new JSONObject(source);
		gson = new Gson();
	}

	public static void main(String[] args) throws IOException {
		EnseigneDeserializer e = new EnseigneDeserializer();
		System.out.println(e.getItems());
	}

	public List<ItemDiscount> getItemDiscount() {
		return fakeList();
	}

	private List<ItemDiscount> fakeList() {
		List<ItemDiscount> list = new ArrayList<>();
		list.add(new ItemDiscount("Pure Soupe", 12.2, 20, "/images/produit1.jpg"));
		list.add(new ItemDiscount("Pure Soupe light", 14.2, 30, "/images/produit1.jpg"));
		list.add(new ItemDiscount("Soupe", 7.2, 10, "/images/produit1.jpg"));
		list.add(new ItemDiscount("Soupe ", 9.2, 20, "/images/produit1.jpg"));
		return list;
	}

	public List<ItemPhare> getItems() {
		return gson.fromJson(data.get("items").toString(), new TypeToken<List<ItemPhare>>() {
		}.getType());
	}

	public String getLogoPath() {
		return data.getString("logo");
	}
}
