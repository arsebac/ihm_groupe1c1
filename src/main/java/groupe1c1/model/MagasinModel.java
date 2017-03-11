package groupe1c1.model;

import com.google.gson.Gson;
import groupe1c1.model.data.Magasin;
import groupe1c1.persistence.json.gson.MagasinsDeserializer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DavidLANG on 01/03/2017.
 */
public class MagasinModel {

    List<Magasin> magasins = new ArrayList<>();

    public MagasinModel() {
        MagasinsDeserializer magasinsDeserializer = new MagasinsDeserializer();
        magasins = magasinsDeserializer.deserialize();
    }

    private Magasin tempCreateMagasin() {
        Magasin magasin = new Magasin(
                "Carrefour nice",
                "pas encore utiliser",
                "Centre commercial de nice",
                "random adresse",
                "04 78 98 22 41",
                "carrefour.nice@gmail.com",
                "carrefournice.fr"
        );

        return magasin;
    }

    public List<Magasin> get() {
        List<Magasin> magasins = new ArrayList<>();

        magasins.add(tempCreateMagasin());
        magasins.add(tempCreateMagasin());
        return magasins;
    }
    
    public void add(Magasin magasin) {
        //List<Magasin> magasins = new Gson().toJson();
    }

    public static void main(String[] args) {
        System.out.println(new MagasinModel().get());
    }

}
