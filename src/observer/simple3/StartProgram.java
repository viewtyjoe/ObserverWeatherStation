package observer.simple3;

/**
 * This example is virtually the same as the previous, except that now we are
 * using the proper terminology such as Observable for the Publisher and
 * Observer for the Subscriber.
 * 
 * @author jlombardo
 */
public class StartProgram {

    public static void main(String[] args) throws InterruptedException {
        HumainSociety hs = new HumainSociety("Waukesha County Humain Society");

        // Create some people for testing...
        Person john = new Person("John Doe", 0, 0);
        Person sally = new Person("Sally Smith", 501, 0);
        Person billy = new Person("Billy Bob", 0, 301);

        // Register two people as having interest in receiving
        // notifications from the Humain Society
        hs.addObserver(john);
        hs.addObserver(sally);

        // Now have the Humain Society do something that triggers
        // notifications...
        Thread.sleep(3000); // not required, just slow things down
        hs.addAnimalForAdoption(new Dog("Fido","Labrador", 1));
        Thread.sleep(3000); // not required, just slow things down
        hs.addAnimalForAdoption(new Cat("Sultan","Siamese", 2));

        Thread.sleep(3000); // not required, just slow things down

        // Now register Billy AFTER some activity has already taken place.
        // Notice how Billy only gets the newest notifications.
        hs.addObserver(billy);
        hs.adoptAnimal(john, (new Dog("Fido","Labrador", 1)));

        Thread.sleep(3000); // not required, just slow things down
        hs.deleteObserver(john);
        hs.addAnimalForAdoption(new Dog("Max", "Collie", 3));


    }
}
