package observer.simple3;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * This class acts as a publisher of information in the Observer pattern.
 * In the Observer pattern publishers are called "Subject" or "Observable".
 * Although the super class java.util.Observable is implemented here, allowing
 * multiple publishers to act that same way, there is nothing
 * about the Observer Pattern that requires you to extend this super class. And,
 * in fact, this may be problematic in your program, since Observable is a
 * concrete class and you can only extend one concrete class. You may want
 * to use a custom interface by the same name and implement similar methods.
 * 
 * @author jlombardo
 */
public class HumainSociety extends Observable {
    private String name;
    private List<Animal> animalsForAdoption;

    public HumainSociety(String name) {
        this.name = (name == null || name.length() == 0) ? "unknown" : name;
        animalsForAdoption = new ArrayList<Animal>();
    }

    public void adoptAnimal(Person p, Animal a) {
       setChanged();
       removeAnimalForAdoption(p, a);
    }

    public void addAnimalForAdoption(Animal a) {
        animalsForAdoption.add(a);
        setChanged();
        notifyObservers("Adopt a pet. Our newest animal: "
                    + a.toString());
    }

    private void removeAnimalForAdoption(Person p, Animal a) {
        animalsForAdoption.remove(a);
        notifyObservers("Our friend " + a.toString()
                + ", has been adopted by "  + p.toString());
    }

    @Override
    public String toString() {
        return name;
    }
}
