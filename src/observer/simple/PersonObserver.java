package observer.simple;

import java.util.Map;

/**
 *
 * @author Jim
 */
public class PersonObserver implements EventObserver {

    @Override
    public void processEvent(Map<String, Object> data) {
        System.out.println("Changed property: [old -> "
                + data.get("oldValue") + "] | [new -> " + data.get("newValue") + "]");

    }
}
