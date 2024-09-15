import java.util.*;

class Main {
  public static void main(String[] args) {
    // Basic Intro
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to Planet of Apes.");
    System.out.println("What is your charecter's name?");
    String name = input.next();
    System.out.println("Welcome to the Planet of the Apes " + name + "!");

    // Create the player
    PlayerClass player = new PlayerClass();

    // Description of the game
    System.out.println();// To improve the output's readability
    System.out.println("You're in a post-apocalyptic world. Both humans and smart apes clash for control of Earth.\n"
        + "Both groups are fighting to become Earth's dominant species.\n"
        + "Your goal is to reach the human settlment.\n"
        + "You should avoid all other settlments and try to avoid any other dangers.\n"
        + "There are dangers that could end your gameplay. Be careful!");

    // Create the map, rooms, and related objects
    System.out.println();
    Forest currMap = new Forest();
    System.out.print("The current map is: ");
    currMap.displayRoom();

    // Menu Options
    int userChoice = 0;
    do {
      System.out.println("The game is starting now. Your options are:");
      System.out.println("1. Display location\n"
                        +"2. Move\n"
                        +"3. Previous location\n" //calls getMoveFrom
                        +"4. Look\n"
                        +"5. Pickup item\n"
                        +"6. Drop item\n"
                        +"7. Use item\n"
                        +"8. Show inventory\n");
    } while (userChoice != 4);

    // End of game
    input.close();
    System.out.println("The game has ended. Thank you for playing!");
  }
}
