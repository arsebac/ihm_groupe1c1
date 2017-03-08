package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import groupe1c1.model.data.Affiche;
import groupe1c1.model.data.ItemPhare;
import org.json.JSONObject;

import java.io.*;
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

		InputStream is = getClass().getResourceAsStream(FILENAME);
		BufferedReader re = new BufferedReader(new InputStreamReader(is));
		String source = "";
		String line;
		while ((line = re.readLine())!= null){
			source += line +"\n";
		}
		data = new JSONObject(source);
		gson = new Gson();
	}
	public List<Affiche> getAffiches(){
		return gson.fromJson(data.get("affiches").toString(), new TypeToken<List<Affiche>>(){}.getType());
	}

	public List<ItemPhare> getItems(){
		return gson.fromJson(data.get("items").toString(), new TypeToken<List<ItemPhare>>(){}.getType());
	}
	public String getLogoPath(){
		return data.getString("logo");
	}
	public static void main(String[] args) throws IOException {
		EnseigneDeserializer e = new EnseigneDeserializer();
		System.out.println(e.getItems());
	}
}
