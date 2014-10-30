package observer.simple2;

/**
 *
 * @author jlombardo
 */
public interface Subscriber {

    public abstract void update(Publisher pub, String info);
}
