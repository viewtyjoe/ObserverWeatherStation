package observer.simple;

/**
 *
 * @author Jim
 */
public class Startup {
    public static void main(String[] args) {
        // Need an Observable object with some old data
        Person p = new Person("Peter","Pan");
        
        // Need some subscriber objects
        PersonObserver observer = new PersonObserver();
        p.addSubscriber(observer);
        
        // Now ask the publisher to do something
        // Subscribers will be notified
        p.setFirstName("George");
        p.setLastName("Jones");
    }
}
