/**
 * Created by Vika on 03.03.2017.
 */
public class Person {

    private String name;
    private String surname;
    private int age;

    Person(String name, String surname, int age) {
        this.name = name;
        this.age = age;
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

}