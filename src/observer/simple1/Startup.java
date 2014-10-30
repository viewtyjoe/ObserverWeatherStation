package observer.simple1;

/**
 * This class starts the program after performing some basic initialization.
 * 
 * @author jlombardo
 */
public class Startup {
    public static void main(String[] args) {
        // Need a publisher object 
        EventPublisher pub = new EventPublisher();
        
        // Need some subscriber objects
        Gadget gadget1 = new Gadget();
        pub.addSubscriber(gadget1);
        
        Gadget gadget2 = new Gadget();
        pub.addSubscriber(gadget2);
        
        Widget widget1 = new Widget();
        pub.addSubscriber(widget1);
        
        // Now ask the publisher to do something
        // Subscribers will be notified
        pub.doSomething();
    }
}
