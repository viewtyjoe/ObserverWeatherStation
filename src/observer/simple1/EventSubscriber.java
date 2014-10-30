package observer.simple1;

import java.util.Map;

/**
 * This is the general contract for all subscribers to the EventPublisher.
 * 
 * @author jlombardo
 */
public interface EventSubscriber {
    public abstract void processEvent(Map<String, Object> data);
}
