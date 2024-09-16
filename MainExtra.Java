import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        // Create rooms
        Room forest = new Room("Forest", "A dense forest with towering trees.");
        Room apeSettlement = new Room("Ape Settlement", "A settlement controlled by the smart apes.");
        Room cave = new Room("Cave", "A dark, damp cave with strange echoes.");

        // Set room exits
        forest.addExit("north", apeSettlement);
        apeSettlement.addExit("south", forest);
        forest.addExit("east", cave);
        cave.addExit("west", forest);

        // Create some items and add them to rooms
        Item sword = new Item("Sword", "A sharp blade.");
        Item map = new Item("Map", "A map of the forest.");
        Item potion = new Item("Potion", "A healing potion that restores health.");
        forest.addContent(sword.getName(), sword);
        cave.addContent(map.getName(), map);
        cave.addContent(potion.getName(), potion);

        // Create the player starting in the forest with 100 HP
        PlayerClass player = new PlayerClass(forest, 100);

        // Basic introduction
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Planet of Apes.");
        System.out.print("What is your character's name? ");
        String name = input.next();
        System.out.println("Welcome, " + name + "! Your adventure begins now.");

        // Game loop
        int userChoice;
        do {
            System.out.println("Options:");
            System.out.println("1. Display location");
            System.out.println("2. Move");
            System.out.println("3. Look around");
            System.out.println("4. Pickup item");
            System.out.println("5. Drop item");
            System.out.println("6. Show inventory");
            System.out.println("7. Show HP");
            System.out.println("8. Quit game");
            System.out.print("Enter your choice: ");
            userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    player.getLocationRoom().interact();
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
                    System.out.print("Enter item name to pick up: ");
                    String itemName = input.next();
                    player.pickup(itemName);
                    break;
                case 5:
                    System.out.print("Enter item name to drop: ");
                    itemName = input.next();
                    player.drop(itemName);
                    break;
                case 6:
                    player.showInventory();
                    break;
                case 7:
                    System.out.println("Your current HP: " + player.getHp());
                    break;
                case 8:
                    System.out.println("Exiting game. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            // Check if the player is still alive after the action
            if (player.getHp() <= 0) {
                System.out.println("You have died! Game over.");
                break;
            }
        } while (userChoice != 8);

        input.close();
    }
}
