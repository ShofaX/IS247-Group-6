import java.util.HashMap;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private Map<String, Item> contents;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.contents = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addContent(String itemName, Item item) {
        contents.put(itemName, item);
    }

    public Item getItem(String itemName) {
        return contents.get(itemName);
    }

    public void removeItem(String itemName) {
        contents.remove(itemName);
    }

    public void interact() {
        System.out.println("You are now in " + name + ". " + description);
        if (!contents.isEmpty()) {
            System.out.println("You can see these items:");
            contents.forEach((itemName, item) -> System.out.println("- " + itemName + ": " + item.getDescription()));
        } else {
            System.out.println("The room is empty.");
        }
        System.out.println("Exits available: " + exits.keySet());
    }
}
