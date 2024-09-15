import java.util.ArrayList;
import java.util.List;

// This is the basic code, I still have stuff to add based on other classes and maybe more.
// - Andrei

public class PlayerClass {
    private String location;
    private String movefrom; 
    private ArrayList<String> inventory;

    public PlayerClass(String startingLocation) {
        this.location = startingLocation;
        this.inventory = new ArrayList<>();
    }

    // Get player's current location
    public String getLocation() {
        return location;
    }

    // Set player's location (moving to a new area)
    public void move(String newLocation) {
        System.out.println("Moving from " + location + " to " + newLocation);
        this.location = newLocation;
    }

    // Look at an object
    public void look(String object) {
        System.out.println("You look at the " + object);
    }

    // Pick up an item
    public void pickup(String item) {
        inventory.add(item);
        System.out.println("You picked up: " + item);
    }

    // Drop an item
    public void drop(String item) {
        if (inventory.remove(item)) {
            System.out.println("You dropped: " + item);
        } else {
            System.out.println("You don't have that item.");
        }
    }

    // Use an item
    public void use(String item) {
        if (inventory.contains(item)) {
            System.out.println("You used: " + item);
            // Additional logic for item effects can be added here
        } else {
            System.out.println("You don't have that item.");
        }
    }

    // View inventory
    public void showinventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: " + inventory);
        }
    }
}

