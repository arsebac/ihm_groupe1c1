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
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("persistence/magasin.json").getFile());
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getPath()));
            String toWrite = new Gson().toJson(magasins);
            writer.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
