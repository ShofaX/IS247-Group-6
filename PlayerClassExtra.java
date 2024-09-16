import java.util.ArrayList;

public class PlayerClass {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int hp;  // Health points

    public PlayerClass(Room startingRoom, int startingHp) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.hp = startingHp;
    }

    public Room getLocationRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved to " + currentRoom.getName());
            currentRoom.interact();
            takeDamage(10); 
        } else {
            System.out.println("There's no exit in that direction.");
        }
    }

    public void lookAround() {
        currentRoom.interact();
    }

    public void pickup(String itemName) {
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(itemName);
            System.out.println("You picked up: " + item.getName());

            // Use a healing item if it's a potion
            if (itemName.equalsIgnoreCase("Potion")) {
                heal(20);
            }
        } else {
            System.out.println("Item not found.");
        }
    }

    public void drop(String itemName) {
        boolean found = false;
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.remove(item);
                currentRoom.addContent(itemName, item);
                System.out.println("You dropped: " + itemName);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("You don't have that item.");
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory: " + inventory);
        }
    }

    public int getHp() {
        return hp;
    }

    public void takeDamage(int amount) {
        hp -= amount;
        System.out.println("You took " + amount + " damage. Current HP: " + hp);
    }

    public void heal(int amount) {
        hp += amount;
        System.out.println("You healed " + amount + " HP. Current HP: " + hp);
    }
}
