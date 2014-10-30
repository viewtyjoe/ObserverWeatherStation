package observer.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import observer.simple1.EventSubscriber;

/**
 *
 * @author Jim
 */
public class Person {
    private List<EventObserver> observers;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        observers = new ArrayList<>();
    }

    // Only the publisher should have access to this method
    private void notifyObservers(Map<String, Object> data) {
        for(EventObserver s : observers) {
            s.processEvent(data);
        }
    }
    
    public void addSubscriber(EventObserver observer) {
        observers.add(observer);
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        Map<String, Object> data = new HashMap<>();
        data.put("oldValue",this.firstName);
        this.firstName = firstName;
        data.put("newValue",firstName);
        notifyObservers(data);
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        Map<String, Object> data = new HashMap<>();
        data.put("oldValue",this.lastName);
        this.lastName = lastName;
        data.put("newValue",lastName);
        notifyObservers(data);
    }
}
