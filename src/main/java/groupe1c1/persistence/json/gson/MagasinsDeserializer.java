package groupe1c1.persistence.json.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import groupe1c1.model.data.Magasin;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by DavidLANG on 03/03/2017.
 */
public class MagasinsDeserializer {

    public List<Magasin> deserialize() {
        String jsonMagasin = readFile();

        if (jsonMagasin != null) {
            Gson gson = new Gson();
            return gson.fromJson(jsonMagasin, new TypeToken<List<Magasin>>(){}.getType());
        }
        return null;
    }

    private String readFile() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            //File file = new File(classLoader.getResource(fileName).getFile());


            URL url = getClass().getResource("/persistence/magasin.json");
            System.out.println(url.getPath());
            return new String(Files.readAllBytes(Paths.get(url.getPath())));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return null;
        }
    }

}
