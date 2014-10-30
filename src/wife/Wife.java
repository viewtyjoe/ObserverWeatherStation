package wife;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Instlogin
 */
public class Wife {
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();
    
    public void addSubscriber(Subscriber s) {
        subscribers.add(s);
    }
    
    public void takeOutGarbage() {
        notifySubscribers();
    }
    
    private void notifySubscribers() {
        for(Subscriber s : subscribers) {
            s.update();
        }
    }
}
