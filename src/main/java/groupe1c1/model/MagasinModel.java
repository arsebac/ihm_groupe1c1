package groupe1c1.model;

import com.google.gson.Gson;
import groupe1c1.model.data.Magasin;
import groupe1c1.persistence.json.gson.MagasinsDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DavidLANG on 01/03/2017.
 */
public class MagasinModel {

    List<Magasin> magasins = new ArrayList<>();

    public MagasinModel() throws IOException {
       MagasinsDeserializer magasinsDeserializer = new MagasinsDeserializer();
       magasins = magasinsDeserializer.deserialize();
    }


    public List<Magasin> get() {
        return magasins;
    }
    
    public void add(Magasin magasin) {
        //List<Magasin> magasins = new Gson().toJson();
    }

}
