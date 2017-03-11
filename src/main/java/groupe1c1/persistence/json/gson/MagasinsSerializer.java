package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import groupe1c1.model.data.Magasin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by DavidLANG on 03/03/2017.
 */
public class MagasinsSerializer {

    public void serialize(List<Magasin> magasins) {
        Gson gson = new Gson();

//        System.out.println(gson.toJson(magasins));
    }

}
