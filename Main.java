import java.util.Scanner;

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

    // Menu Options
    int userChoice = 0;
    do {
      System.out.println("The game is starting now. Your options are (1-9_:");
      System.out.println("1. Display location\n"
                        +"2. Move\n"
                        +"3. Previous location\n" //calls getMoveFrom
                        +"4. Look\n"
                        +"5. Pickup item\n"
                        +"6. Drop item\n"
                        +"7. Use item\n"
                        +"8. Show inventory\n"
                        +"9. Quit game");
      Switch(userChoice){
        String item;
        
        case 1:
          System.out.println(name + "'s current location is:");
          System.out.println(player.getLocation());
          break;
        case 2:
          System.out.println("What location do you want to move to?");
          String newLocation = input.next();
          player.move(newLocation);
          break;
        case 3:
          System.out.println("Your previous location was:");
          player.getMoveFrom();
          break;
        case 4:
          System.out.println("What item do you want to look at?");
          item = input.next();
          player.look(item);
          break;
        case 5:
          System.out.println("What item do you want to look at?");
          item = input.next();
          player.pickup(item);
          break;
        case 6:
          System.out.println("What item do you want to dop?");
          item = input.next();
          player.drop(item);
          break;
        case 7:
          System.out.println("What item do you want to use?");
          item = input.next();
          player.drop(item);
          break;
        case 8:
          player.showInventory();
          break;
        case 9:
          System.out.println("User has quit the game. Exiting game now.");
          break;
        default:
          System.out.println("Error: Unrecognized input. Only integers from 1 to 9 are accepted. Please try again.");
      }
    } while (userChoice != 9);

    // End of game
    input.close();
    System.out.println("The game has ended. Thank you for playing!");
  }
}
