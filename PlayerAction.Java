import java.util.ArrayList;
  

public class PlayerClass {
    private String location;
    private String moveFrom; 
    private ArrayList<Item> inventory;
    private int numberOfObjects;

   
    public PlayerClass(String startingLocation, String moveFrom, int numberOfObjects) {
        this.location = startingLocation;
        this.moveFrom = moveFrom;
        this.inventory = new ArrayList<>();
        this.numberOfObjects = numberOfObjects;
    }

   
    public PlayerClass(String startingLocation) {
        this(startingLocation, null, 0);
    }

    // To get player's current location
    public String getLocation() {
        return location;
    }

    // To set a player's location (or moving to a new area)
    public void move(String newLocation) {
        System.out.println("Moving from " + location + " to " + newLocation);
        this.moveFrom = location;  
        this.location = newLocation;
    }

    // To get a player's previous location
    public String getMoveFrom() {
        return moveFrom;
    }

    // To look at an object
    public void look(String object) {
        System.out.println("You look at the " + object);
    }

    // To pick up an item
    public void pickup(Item item) {
        inventory.add(item);
        numberOfObjects++;
        System.out.println("You picked up: " + item);
    }

    // To drop an item
    public void drop(Item item) {
        if (inventory.remove(item)) {
            numberOfObjects--;
            System.out.println("You dropped: " + item);
        } else {
            System.out.println("You don't have that item.");
        }
    }

    // To use a item
    public void use(Item item) {
        if (inventory.contains(item)) {
            System.out.println("You used: " + item);
       
        } else {
            System.out.println("You don't have that item.");
        }
    }

    // To view inventory
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: " + inventory);
        }
    }

    // To get the number of objects in inventory
    public int getNumberOfObjects() {
        return numberOfObjects;
    }  
  }



