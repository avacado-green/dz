import java.util.*;
public class Store {private Set<Laptop> laptops;

    public Store() {
        laptops = new HashSet<>();
    }

    public void addLaptop(Laptop laptop) {
        laptops.add(laptop);
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }
}
