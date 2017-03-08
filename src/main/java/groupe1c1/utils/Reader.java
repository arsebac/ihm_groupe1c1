package groupe1c1.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by DavidLANG on 08/03/2017.
 */
public class Reader {

    public String read(String path) {
        String toReturn = "";
        ClassLoader classLoader = getClass().getClassLoader();
        String pathFile = classLoader.getResource(path).getFile();
        if (pathFile != null) {
            File file = new File(pathFile);
            toReturn = read(file);
        }
        return toReturn;
    }

    private String read(File file) {
        try {
            return new String(Files.readAllBytes(Paths.get(file.getPath())));
        } catch (IOException e) {
            return "";
        }
    }

}
