import java.util.Properties;
import java.sql.*;

/**
 * Created by Alexey on 05.03.2017.
 */
public class ConnectToDb {

    private static final Properties mainProperties = PropertiesUtil.getProperties();
    private static String DB_URL = mainProperties.getProperty("db.url");
    private static String USERNAME = mainProperties.getProperty("username");
    private static String PASSWORD = mainProperties.getProperty("password");
    private static String DRIVER = mainProperties.getProperty("jdbc.driver");

    private Connection conn;
    private Statement stmt;


    public Statement doConnect() {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // getting Statement object to execute query
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }  catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }

        return stmt;
    }

    public void closeConnect() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
