import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Forest {
    private String description;
    private ArrayList<String> contents;
    private Random random;
    private boolean hasMachete;
    private boolean hasLighter;
    private boolean hasWildBerries;
    private boolean hasWildFruit;

    // Constructor with description of the room, using boolean for all attributes
    public Forest() {
        description = "You have reached the dense Jungle of Ape Mountain.\n" +
                      "The jungle is treacherous and filled with dangerous creatures.\n" +
                      "Your goal is to navigate through the forest and reach safety.";
        contents = new ArrayList<>();
        random = new Random();
        initializeContents();
        hasMachete = false;
        hasLighter = false;
        hasWildBerries = false;
        hasWildFruit = false;
    }

    // this will intialize the contents of the room with some random elements
    private void initializeContents() {
        contents.add("Machete");
        contents.add("Old Lighter");

        // I want to randomize asking the user if they want wild berries or fruit
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                contents.add("Wild berries");
                hasWildBerries = true;
            } else {
                contents.add("Wild fruit");
                hasWildFruit = true;
            }
        }
    }

    // displays room description to user
    public void displayRoom() {
        System.out.println(description);
    }

    // setting up the beginning interaction for the room
    public boolean interact() {
        Scanner sc = new Scanner(System.in);

        System.out.println("You stand at a crossroads. The path forks east and west.\n" +
                           "As you consider your options, you come across an old backpack.\n" +
                           "Inside, you find an old lighter and a machete.");

        // Choice to pick up the lighter or not
        String pickLighter;
        while (true) {
            System.out.println("Do you want to pick up the lighter to use it as a torch? (yes/no)");
            pickLighter = sc.nextLine().trim().toLowerCase();
            if (pickLighter.equals("yes") || pickLighter.equals("no")) {
                break;
            }
            System.out.println("That's not an option, try again.");
        }

        if (pickLighter.equals("yes")) {
            hasLighter = true;
            System.out.println("You decide to pick up the lighter. With the torch, you can now see at night.\n" +
                               "However, be cautious, the torch may attract the attention of apes in the forest.");
        } else {
            System.out.println("You choose to skip using the lighter. Proceeding in the dark...");
        }

        // Choice to pick up the machete or not
        String pickMachete;
        while (true) {
            System.out.println("Do you want to pick up the machete? (yes/no)");
            pickMachete = sc.nextLine().trim().toLowerCase();
            if (pickMachete.equals("yes") || pickMachete.equals("no")) {
                break;
            }
            System.out.println("That's not an option, try again.");
        }

        if (pickMachete.equals("yes")) {
            hasMachete = true;
            System.out.println("You take the machete with you. It could be useful for defense and clearing obstacles.");
        } else {
            System.out.println("You leave the machete behind.");
        }

        // Beginning to decision to find the path out of the forest and start game
        String pathChoice;
        while (true) {
            System.out.println("You must decide which direction to go. The path splits into three directions: left, right, and straight.\n" +
                               "Which way do you want to go? (left/right/straight)");
            pathChoice = sc.nextLine().trim().toLowerCase();
            if (pathChoice.equals("left") || pathChoice.equals("right") || pathChoice.equals("straight")) {
                break;
            }
            System.out.println("That's not an option, try again.");
        }

        System.out.println("You choose to go " + pathChoice + " and proceed cautiously.");

        // Encounter with a bear or ape depending on if they have machete
        if (!hasLighter && !hasMachete) {
            System.out.println("You encounter a bear and have no means of defense.\n" +
                               "The bear attacks and you don't survive.\n" +
                               "Game over. Restarting...");
            return false; // Game over and restarting
        } else if (!hasLighter && hasMachete) {
            System.out.println("You encounter a bear but manage to fend it off with the machete.\n" +
                               "However, you are now lost and must find your way out of the forest.");
        }

        // Decision to go towards or away from the ape roar
        String directionChoice;
        while (true) {
            System.out.println("As you make your way through the jungle, you hear an ape roar in the distance.\n" +
                               "Do you want to go towards the roar or away from it? (towards/away)");
            directionChoice = sc.nextLine().trim().toLowerCase();// makes sure they user input is lowercase without any extra stuff
            if (directionChoice.equals("towards") || directionChoice.equals("away")) {
                break;
            }
            System.out.println("That's not an option, try again.");
        }

        if (directionChoice.equals("towards")) {
            if (hasMachete) {
                System.out.println("You encounter an ape. Thankfully, you have the machete and manage to defend yourself.\n" +
                                   "The ape retreats, and you survive the encounter.");
            } else {
                System.out.println("The ape attacks you, and you are unable to defend yourself.\n" +
                                   "Game over. Restarting...");
                return false; // Game over and will restart
            }
        } else {
            System.out.println("You avoid the ape and continue on your path.");
        }

        // Asking about eating wild berries or wild fruit
        if (hasWildBerries || hasWildFruit) {
            String eatWild;
            while (true) {
                System.out.println("You feel hungry and come across some wild food.\n" +
                                   (hasWildBerries ? "You see some wild berries. " : "") +
                                   (hasWildFruit ? "You see some wild fruit. " : "") +
                                   "Do you want to eat it? (yes/no)");
                eatWild = sc.nextLine().trim().toLowerCase();// makes sure they user input is lowercase without any extra stuff
                if (eatWild.equals("yes") || eatWild.equals("no")) {
                    break;
                }
                System.out.println("That's not an option, try again.");
            }

            if (eatWild.equals("yes")) {
                if (hasWildBerries && random.nextBoolean()) {
                    System.out.println("The berries turn out to be poisonous. You choke and die.\n" +
                                       "Game over. Restarting...");
                    return false; // Game over
                } else if (hasWildFruit) {
                    System.out.println("The wild fruit replenishes your energy, allowing you to continue.");
                }
            } else {
                System.out.println("You wisely avoid eating the wild food and continue on your path.");
            }
        }

        // Successfully navigate through the forest
        System.out.println("After navigating the twists and turns of the jungle, you finally see the edge of the forest.\n" +
                           "You have successfully navigated through the jungle and reached the base of the mountain.\n" +
                           "Congratulations on surviving the Jungle of Ape Mountain!");
        return true; // Successful completion
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) { // Infinite loop for restarting the game
            Forest forest = new Forest();
            forest.displayRoom();
            boolean gameRunning = forest.interact();

            if (!gameRunning) {
                String userChoice;
                while (true) {
                    System.out.println("Do you want to play again or quit? (play/quit)");
                    userChoice = sc.nextLine().trim().toLowerCase();
                    if (userChoice.equals("play") || userChoice.equals("quit")) {
                        break;
                    }
                    System.out.println("That's not an option, try again.");
                }

                if (userChoice.equals("quit")) {
                    System.out.println("Thanks for playing! Goodbye.");
                    break; // Exit the game
                }
            } else {
                System.out.println("Congratulations! You've successfully navigated through the forest.");
                break; // End the game after a successful run
            }
        }

        sc.close(); // Close the scanner
    }
}