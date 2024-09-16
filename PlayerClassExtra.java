import java.util.ArrayList;

public class PlayerClass {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private int hp;

    public PlayerClass(Room startingLocation, int startingHp) {
        this.currentRoom = startingLocation;
        this.inventory = new ArrayList<>();
        this.hp = startingHp;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            System.out.println("Moving from " + currentRoom.getName() + " to " + nextRoom.getName());
            currentRoom = nextRoom;

            // Check for specific room effects
            if (currentRoom.getName().equals("Ape Settlement")) {
                System.out.println("You've entered the Ape Settlement. You lost 30 HP!");
                hp -= 30;
                if (hp <= 0) {
                    System.out.println("You have died, and couldn't get to the human settlement");
                    hp = 0; // Ensure HP does not go below 0
                }
            }
        } else {
            System.out.println("You can't move in that direction.");
        }
    }

    public void pickup(String itemName) {
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            inventory.add(item);
            System.out.println("You picked up: " + item.getName());
        } else {
            System.out.println("No such item in this room.");
        }
    }

    public void drop(String itemName) {
        Item itemToDrop = null;
        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                itemToDrop = item;
                break;
            }
        }
        if (itemToDrop != null) {
            inventory.remove(itemToDrop);
            System.out.println("You dropped: " + itemToDrop.getName());
        } else {
            System.out.println("You don't have that item.");
        }
    }

    public void use(String itemName) {
        Item itemToUse = null;
        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                itemToUse = item;
                break;
            }
        }
        if (itemToUse != null) {
            System.out.println("You used: " + itemToUse.getName() + ". " + itemToUse.getDescription());
            // For if the person uses a potion
            if (itemToUse.getName().equals("Potion")) {
                hp += 20; // Heal 20 HP
                System.out.println("You restored 20 HP. Current HP: " + hp);
                inventory.remove(itemToUse); 
            }
        } else {
            System.out.println("You don't have that item.");
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory: ");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }

    public void lookAround() {
        currentRoom.interact();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

}
