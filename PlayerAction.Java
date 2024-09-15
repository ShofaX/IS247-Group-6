import java.util.ArrayList;

public class PlayerClass {
    private String location;
    private String moveFrom; 
    private ArrayList<String> inventory;
    private int numberOfObjects;

    // Constructor with starting location and moveFrom
    public PlayerClass(String startingLocation, String moveFrom, int numberOfObjects) {
        this.location = startingLocation;
        this.moveFrom = moveFrom;
        this.inventory = new ArrayList<>();
        this.numberOfObjects = numberOfObjects;
    }

    // Overloaded constructor if only location is provided
    public PlayerClass(String startingLocation) {
        this(startingLocation, null, 0);
    }

    // Get player's current location
    public String getLocation() {
        return location;
    }

    // Set player's location (moving to a new area)
    public void move(String newLocation) {
        System.out.println("Moving from " + location + " to " + newLocation);
        this.moveFrom = location;  // Store the previous location
        this.location = newLocation;
    }

    // Get player's previous location
    public String getMoveFrom() {
        return moveFrom;
    }

    // Look at an object
    public void look(String object) {
        System.out.println("You look at the " + object);
    }

    // Pick up an item
    public void pickup(String item) {
        inventory.add(item);
        numberOfObjects++;
        System.out.println("You picked up: " + item);
    }

    // Drop an item
    public void drop(String item) {
        if (inventory.remove(item)) {
            numberOfObjects--;
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
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: " + inventory);
        }
    }

    // Get the number of objects in inventory
    public int getNumberOfObjects() {
        return numberOfObjects;
    }

    @Override
    public String toString() {
        return "PlayerClass [location=" + location + ", moveFrom=" + moveFrom + 
               ", inventory=" + inventory + ", numberOfObjects=" + numberOfObjects + "]";
    }
}

