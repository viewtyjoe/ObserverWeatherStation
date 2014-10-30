package observer.simple;

import java.util.Map;

/**
 * This is the general contract for all subscribers to the EventPublisher.
 * 
 * @author jlombardo
 */
public interface EventObserver {
    public abstract void processEvent(Map<String, Object> data);
}
