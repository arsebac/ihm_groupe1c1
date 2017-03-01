package groupe1c1.model.parser;

import groupe1c1.model.data.ItemPhare;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

/**
 * @author user
 * @date 01/03/2017
 */
public class ItemParser {
	private final JSONArray itemsJson;
	public ItemParser(String filename) throws IOException {
		InputStream is = getClass().getResourceAsStream(filename);
		BufferedReader re = new BufferedReader(new InputStreamReader(is));
		String source = "";
		String line;
		while ((line = re.readLine())!= null){
			source += line +"\n";
		}


		JSONObject jsonObject = new JSONObject(source);
		itemsJson = jsonObject.getJSONArray("items");
	}
	public int itemSize(){
		return itemsJson.length();
	}

	public ItemPhare getItem(int i) {
		JSONObject itemObject = itemsJson.getJSONObject(i);
		return new ItemPhare(itemObject.getString("nom"),itemObject.getDouble("prix"),itemObject.getString("url"));
	}
}
