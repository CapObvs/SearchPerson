import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String inputValue = "";
        PersonService personService = new PersonService();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputValue = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Person> persons = personService.getPersons(inputValue);

        for (Person person: persons) {
            System.out.println(person.getSurname() + " " + person.getName() + ", age: " + person.getAge() + " years old");
        }
    }
}
