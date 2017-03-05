import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alexey on 15.11.2016.
 */
public class PropertiesUtil {

    public static Properties getProperties() {

        //to load application's properties, we use this class
        Properties mainProperties = new Properties();

        FileInputStream file;

        //the base folder is ./, the root of the main.properties file
        String path = "src/connection.properties";

        //load the file handle for main.properties
        try {
            file = new FileInputStream(path);
            mainProperties.load(file);
            file.close();
        } catch (IOException ex) {
            System.out.println("ERROR: Couldn't find the properties file" + ex.getLocalizedMessage());
        }
        return mainProperties;
    }
}
