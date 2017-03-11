package groupe1c1.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by DavidLANG on 08/03/2017.
 */
public class Reader {

    public String read(String path) throws IOException {
        InputStream is = getClass().getResourceAsStream(path);
        BufferedReader re = new BufferedReader(new InputStreamReader(is));
        String source = "";
        String line;

        while ((line = re.readLine())!= null){
            source += line +"\n";
        }
        return source;
    }

}
