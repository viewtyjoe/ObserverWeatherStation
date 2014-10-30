package observer.simple2;

/**
 *
 * @author jlombardo
 */
public interface Publisher {

    public abstract void registerSubscriber(Subscriber o);

    public abstract void removeSubscriber(Subscriber o);

    public abstract void notifySubscribers(String info);
}
