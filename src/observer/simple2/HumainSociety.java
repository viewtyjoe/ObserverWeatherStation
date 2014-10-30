package observer.simple2;

import java.util.*;

/**
 * This class acts as a publisher of information in the Observer pattern.
 * In the Observer pattern publishers are called "Subject" or "Observable".
 * Although the interface Publisher is implemented here, allowing multiple
 * publishers to act that same way, there is nothing
 * about the Observer Pattern that requires you to implement an interface.
 * 
 * @author jlombardo
 */
public class HumainSociety implements Publisher {
    private String name;
    private List<Subscriber> subscriberList;
    private List<Animal> animalsForAdoption;

    public HumainSociety(String name) {
        this.name = (name == null || name.length() == 0) ? "unknown" : name;
        subscriberList = new ArrayList<Subscriber>();
        animalsForAdoption = new ArrayList<Animal>();
    }

    public void adoptAnimal(Person p, Animal a) {
       removeAnimalForAdoption(p, a);
    }

    @Override
    public void notifySubscribers(String info) {
        for(Subscriber s : subscriberList) {
            s.update(this, info);
        }
    }

    @Override
    public void registerSubscriber(Subscriber s) {
        subscriberList.add(s);
    }

    @Override
    public void removeSubscriber(Subscriber s) {
        subscriberList.remove(s);
    }

    public void addAnimalForAdoption(Animal a) {
        animalsForAdoption.add(a);
        notifySubscribers("Adopt a pet. Our newest animal: "
                    + a.toString());
    }

    private void removeAnimalForAdoption(Person p, Animal a) {
        animalsForAdoption.remove(a);
        notifySubscribers("Our friend " + a.toString()
                + ", has been adopted by "  + p.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
