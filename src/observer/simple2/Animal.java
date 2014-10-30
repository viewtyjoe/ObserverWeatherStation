package observer.simple2;

/**
 *
 * @author jlombardo
 */
public interface Animal {

    int getAge();

    String getBreed();

    String getName();

    void setAge(int age);

    void setBreed(String breed);

    void setName(String name);

    String toString();

}
