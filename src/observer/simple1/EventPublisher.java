package observer.simple1;

import java.util.*;

/**
 * This class represents a simple publisher (Observable) of events.
 * 
 * @author jlombardo
 */
public class EventPublisher {
    private List<EventSubscriber> subscribers;
    
    public EventPublisher() {
        subscribers = new ArrayList<EventSubscriber>();
    }
    
    // Only the publisher should have access to this method
    private void notifySubscribers(Map<String, Object> data) {
        for(EventSubscriber s : subscribers) {
            s.processEvent(data);
        }
    }
    
    public void addSubscriber(EventSubscriber sub) {
        subscribers.add(sub);
    }
    
    /**
     * Nothing happens until we tell the publisher to do something. This is
     * what triggers notifications to subscribers. This method is only a
     * representation. In a real program the method would be more realistic.
     */
    public void doSomething() {
        System.out.println("PUblisher is doing something ... will notify subscribers ...");
        Date date = new Date();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("currentDate", date);
        notifySubscribers(map);
    }
}
