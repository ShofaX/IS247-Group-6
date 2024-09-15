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
    PlayerAction player = new PlayerAction(name);

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
      System.out.println(name + "'s current position is:");
      System.out.println("Temparary output. Need map class and object.\n");
      System.out.println("Your options are (1-4):\n "
          + "1. Move forward.\n "
          + "2. Turn right and move into the corrseponding section.\n "
          + "3. Turn left and move into the corresponding section.\n "
          + "4. Quit Game");
      userChoice = input.nextInt();

      // Update the map based on the user's choice then output
      // Check if they reached the settlement
      System.out.println();
      switch (userChoice) {
        case 1:
          // move forward
          break;
        case 2:
          // turn right
          break;
        case 3:
          // turn left
          break;
        case 4:
          System.out.println("User quits the game.");
          break;
        default:
          System.out.println("Error: Unrecognized choice. You need to enter an integer between 1 and 4.");
      }
    } while (userChoice != 4);

    // End of game
    input.close();
    System.out.println("The game has ended. Thank you for playing!");
  }
}