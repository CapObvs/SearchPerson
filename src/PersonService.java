import java.util.List;

/**
 * Created by Alexey on 05.03.2017.
 */
public class PersonService {
    private PersonDAO personDAO = new PersonDAO();

    public List<Person> getPersons(String inputValue) {
        return personDAO.getPersons(inputValue);
    }
}
