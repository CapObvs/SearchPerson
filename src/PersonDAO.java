import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 05.03.2017.
 */
public class PersonDAO {

    private ConnectToDb connectToDb = new ConnectToDb();

    public ResultSet executeQuery(String query) {
        Statement stmt;
        ResultSet rs = null;
        try {
            stmt = connectToDb.doConnect();
            rs = stmt.executeQuery(query);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        return rs;
    }

    public String buildQuery(String inputValue) {
        String query = "SELECT id, name, surname, age FROM person ";
        Integer age = null;
        try {
            age = Integer.valueOf(inputValue);
            query = query + "where age = " + age;
        } catch (Exception e) {
            query = query + "where name = '" + inputValue +
                    "' or surname = '" + inputValue + "'";
        }
        return query;
    }

    public List<Person> getPersons(String inputValue) {
        List<Person> persons = new ArrayList<Person>();
        String query = buildQuery(inputValue);
        ResultSet rs = executeQuery(query);
        Person person;
        try {
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                person = new Person(name, surname, age);
                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connectToDb.closeConnect();
        return persons;
    }

}
