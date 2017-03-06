package groupe1c1.model;

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
        Magasin magasin = tempCreateFakeMagasin();
        magasins.add(magasin);
        magasins.add(magasin);
    }


    private Magasin tempCreateFakeMagasin() {
        String name = "carrefour genas";
        String imagePath = "titi";
        String horaire = "du lundi au vendredi de 8 à 19h";
        String adresse = "centre de genas";

        return new Magasin(name, imagePath, horaire, adresse);
    }

    public List<Magasin> get() {
        //MagasinsDeserializer magasinsDeserializer = new MagasinsDeserializer();


        //return magasinsDeserializer.deserialize();
        List<Magasin> magasins = new ArrayList<>();
        magasins.add(tempCreateFakeMagasin());
        magasins.add(tempCreateFakeMagasin());
        return magasins;

    }


    public void persist(Magasin magasin) {
        //TODO
    }

}
