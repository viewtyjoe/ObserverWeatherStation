package observer.simple3;

/**
 *
 * @author jlombardo
 */
public class Cat implements Animal {
    private String name;
    private String breed;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cat other = (Cat) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.breed == null) ? (other.breed != null) : !this.breed.equals(other.breed)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 89 * hash + (this.breed != null ? this.breed.hashCode() : 0);
        hash = 89 * hash + this.age;
        return hash;
    }

    
    @Override
    public String toString() {
        return "Name: " + name + ", Breed: " + breed + ", Age: " + age;
    }
}
