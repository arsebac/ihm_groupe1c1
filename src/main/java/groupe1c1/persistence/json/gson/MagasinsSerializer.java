package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import groupe1c1.model.data.Magasin;

import java.util.List;

/**
 * Created by DavidLANG on 03/03/2017.
 */
public class MagasinsSerializer {

    private Gson gson = new Gson();

    public void serialize(List<Magasin> magasins) {
        String magasinJson = gson.toJson(magasins);
        System.out.println(magasinJson);
        //PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
    }

}
