import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private Map<String, String> contents;
    private String puzzle;
    private ArrayList<String> encounters;
    private Random random;

    // Default constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.contents = new HashMap<>();
        this.encounters = new ArrayList<>();
        this.random = new Random();
    }

    // Overloaded constructor for room with puzzle
    public Room(String name, String description, String puzzle) {
        this(name, description);
        this.puzzle = puzzle;
    }

    // Method to add an exit to the room
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    // Method to add contents to the room
    public void addContent(String item, String description) {
        contents.put(item, description);
    }

    // Method to add encounters
    public void addEncounter(String encounter) {
        encounters.add(encounter);
    }

    // Method to interact with the room
    public void interact() {
        System.out.println("You are in the " + name + ".");
        System.out.println(description);
        if (!contents.isEmpty()) {
            System.out.println("You see: ");
            contents.forEach((item, desc) -> System.out.println("- " + item + ": " + desc));
        }
        if (puzzle != null) {
            System.out.println("Puzzle: " + puzzle);
        }
        System.out.println("Exits are available to: " + exits.keySet());
        randomEvent();
    }

    // Method to get the next room based on direction
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    // Method to handle random events/encounters
    private void randomEvent() {
        if (random.nextInt(100) < 40) { // 40% chance of an encounter
            System.out.println("Random Encounter: " + encounters.get(random.nextInt(encounters.size())));
        }
    }

    // Method to solve puzzle
    public boolean solvePuzzle() {
        return random.nextBoolean(); // Randomized success of solving puzzle
    }

}

// Main Game class
public class ApeSettlementGame {
    public static void main(String[] args) {
        // Creating rooms
        Room apeSettlement = new Room(
            "Ape Settlement", 
            "You sneak into a settlement of hostile apes in search of valuable resources."
        );
        
        // Adding items to the room
        apeSettlement.addContent("Weapon", "A crude spear used by the apes.");
        apeSettlement.addContent("Food", "A sack of dried fruit, essential for survival.");
        apeSettlement.addContent("Key", "A shiny key that seems to unlock something.");
        apeSettlement.addContent("Clothes", "A set of ragged clothes used for disguise.");

        // Adding encounters
        apeSettlement.addEncounter("An ape spots you from afar, and starts to approach.");
        apeSettlement.addEncounter("You hear footsteps behind you, but no one is there.");
        apeSettlement.addEncounter("You hear growls in the distance. The apes are nearby!");

        // Adding exits
        Room northExit = new Room("North Exit", "The north exit is guarded by an ape.");
        Room southExit = new Room("South Exit", "The south exit is unguarded but locked. You need a key to escape.");
        apeSettlement.addExit("North", northExit);
        apeSettlement.addExit("South", southExit);

        // Simulating interaction with the room
        apeSettlement.interact();

        // Solving the puzzle (randomized)
        boolean escaped = apeSettlement.solvePuzzle();
        if (escaped) {
            System.out.println("You managed to sneak out of the settlement unnoticed with the items!");
        } else {
            System.out.println("You were caught by the apes! Try again next time.");
        }
    }
}
