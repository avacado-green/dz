import java.util.*;

public class LaptopFilter {

    public static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> criteria) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Laptop laptop : laptops) {
            if (criteria.containsKey("RAM") && laptop.getRam() < (int) criteria.get("RAM")) {
                filteredLaptops.remove(laptop);
            }
            if (criteria.containsKey("Storage") && laptop.getStorage() < (int) criteria.get("Storage")) {
                filteredLaptops.remove(laptop);
            }
            if (criteria.containsKey("OperatingSystem") && !laptop.getOperatingSystem().equals(criteria.get("OperatingSystem"))) {
                filteredLaptops.remove(laptop);
            }
            if (criteria.containsKey("Color") && !laptop.getColor().equals(criteria.get("Color"))) {
                filteredLaptops.remove(laptop);
            }
        }

        return filteredLaptops;
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.addLaptop(new Laptop("Dell", 16, 512, "Windows", "Black"));
        store.addLaptop(new Laptop("HP", 8, 256, "Windows", "Silver"));
        store.addLaptop(new Laptop("Apple", 8, 512, "MacOS", "Gray"));

        Scanner scanner = new Scanner(System.in);
        Map<String, Object> criteria = new HashMap<>();

        System.out.println("Enter the number corresponding to the required criterion:");
        System.out.println("1 - RAM");
        System.out.println("2 - Storage");
        System.out.println("3 - Operating System");
        System.out.println("4 - Color");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter the minimum RAM value:");
                criteria.put("RAM", scanner.nextInt());
                break;
            case 2:
                System.out.println("Enter the minimum storage value:");
                criteria.put("Storage", scanner.nextInt());
                break;
            case 3:
                System.out.println("Enter the operating system:");
                criteria.put("OperatingSystem", scanner.nextLine());
                break;
            case 4:
                System.out.println("Enter the color:");
                criteria.put("Color", scanner.nextLine());
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(store.getLaptops(), criteria);

        System.out.println("Laptops matching the criteria:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}
