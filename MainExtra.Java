import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        // Initialize game world and rooms
        Room forest = new Room("Forest", "A dark, dense forest that's hard to navigate.");
        Room apeSettlement = new Room("Ape Settlement", "A settlement controlled by apes that have taken over the planet.");
        Room cave = new Room("Cave", "A dark cave full of mystery.");
        Room humanSettlement = new Room("Human Settlement", "A safe haven.. for now");

        // Set exits between rooms
        forest.addExit("north", apeSettlement);
        apeSettlement.addExit("south", forest);
        forest.addExit("east", cave);
        cave.addExit("west", forest);
        cave.addExit("north", humanSettlement); // Cave leads to Human Settlement

        // Add items to rooms
        forest.addContent("Potion", new Item("Potion", "A healing potion that restores health."));
        forest.addContent("Map", new Item("Map", "A map of the forest, though it's a map of the wrong forest."));
        cave.addContent("Potion", new Item("Potion", "A healing potion that restores health."));

        // Initialize the player with a starting HP of 100
        PlayerClass player = new PlayerClass(forest, 100);

        // Start game and gather player info
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Planet of the Apes.");
        System.out.print("What is your character's name? ");
        String playerName = input.next();
        System.out.println("Welcome, " + playerName + " ,You're in a post-apocalyptic world. Both humans and smart apes clash for control of Earth.\n"
    	        + "Both groups are fighting to become Earth's dominant species.\n"
    	        + "Your goal is to reach the human settlment.\n"
    	        + "You should avoid all other settlments otherwise you'll take damage, goodluck.");

        boolean gameRunning = true;

        while (gameRunning) {
            // Check if the player has reached the Human Settlement
            if (player.getCurrentRoom().getName().equals("Human Settlement")) {
                System.out.println("Congratulations, " + playerName + "! You have reached the Human Settlement and are safe from the apes!");
                gameRunning = false; // End game
                break;
            }

            // Display menu options
            System.out.println("Menu:");
            System.out.println("1. Display current location");
            System.out.println("2. Move");
            System.out.println("3. Look around");
            System.out.println("4. Pick up item");
            System.out.println("5. Drop item");
            System.out.println("6. Use item");
            System.out.println("7. Show inventory");
            System.out.println("8. Show HP");
            System.out.println("9. Quit game");
            System.out.print("Your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Current location:");
                    player.getCurrentRoom().interact();
                    break;
                case 2:
                    System.out.print("Enter direction to move (north, south, east, west): ");
                    String direction = input.next();
                    player.move(direction);
                    break;
                case 3:
                    player.lookAround();
                    break;
                case 4:
                    System.out.print("Enter the item name to pick up: ");
                    String itemName = input.next();
                    player.pickup(itemName);
                    break;
                case 5:
                    System.out.print("Enter the item name to drop: ");
                    itemName = input.next();
                    player.drop(itemName);
                    break;
                case 6:
                    System.out.print("Enter the item name to use: ");
                    itemName = input.next();
                    player.use(itemName);
                    break;
                case 7:
                    player.showInventory();
                    break;
                case 8:
                    System.out.println("Current HP: " + player.getHp());
                    break;
                case 9:
                    System.out.println("Exiting game. Goodbye!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }

            // Check if the player is still alive after actions
            if (player.getHp() <= 0) {
                System.out.println("You have died! Game over.");
                gameRunning = false;
            }
        }

        input.close();
    }
}

}
