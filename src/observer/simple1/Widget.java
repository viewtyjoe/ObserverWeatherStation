package observer.simple1;

import java.util.Map;

/**
 * This class represents a simple Subscriber (Observer). It must implement
 * a common interface that all similar subscribers use. The method or methods
 * of the interface are what are called by the publisher when it wants to
 * notify its subscribers that something happened.
 * 
 * @author jlombardo
 */
public class Widget implements EventSubscriber {

    /**
     * Notice that each subscriber can do something different in response
     * to the notification.
     */
    @Override
    public void processEvent(Map<String, Object> data) {
        System.out.println("The last time we met was: "
                + data.get("currentDate"));
    }
    
}
