import java.util.Scanner;

public class GameMain {
	public static void main(String[] args) {
		// Create the map
	    Forest startLocation = new Forest();
	    
	    // Create the player
	    PlayerClass player = new PlayerClass("Forest");
	    
	    // Basic introduction
	    Scanner input = new Scanner(System.in);
	    System.out.println("Welcome to Planet of Apes.");
	    System.out.println("What is your charecter's name?");
	    String name = input.next();
	    System.out.println("Welcome to the Planet of the Apes " + name + "!");

	    // Description of the game
	    System.out.println();// To improve the output's readability
	    System.out.println("You're in a post-apocalyptic world. Both humans and smart apes clash for control of Earth.\n"
	        + "Both groups are fighting to become Earth's dominant species.\n"
	        + "Your goal is to reach the human settlment.\n"
	        + "You should avoid all other settlments and try to avoid any other dangers.\n"
	        + "There are dangers that could end your gameplay. Be careful!");
	    
	    System.out.println();
	    System.out.println("Your starting location is a forest.");
	    startLocation.displayRoom();

	    // Menu options
	    int userChoice = 0;
	    do {
	      System.out.println("The game is starting now. Your options are (1-9):");
	      System.out.println("1. Display location\n"
	                        +"2. Move\n"
	                        +"3. Previous location\n"
	                        +"4. Look\n"
	                        +"5. Pickup item\n"
	                        +"6. Drop item\n"
	                        +"7. Use item\n"
	                        +"8. Show inventory\n"
	                        +"9. Quit game");
	      userChoice = input.nextInt();
	      
	      // Process the user's choice
	      String item;
	      switch(userChoice){
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
	         // errors with these three cases
	        case 5:
	          System.out.println("What item do you want to look at?");
	          break;
	        case 6:
	          System.out.println("What item do you want to dop?");
	          break;
	        case 7:
	          System.out.println("What item do you want to use?");
	          break;
	        //end of errors
	        case 8:
	          player.showInventory();
	          break;
	        case 9:
	          System.out.println("User has quit the game. Exiting game now.");
	          break;
	        default:
	          System.out.println("Error: Unrecognized input. Only integers from 1 to 9 are accepted. Please try again.");
	          System.out.println(userChoice);
	          userChoice = 9;
	      }
	    } while (userChoice != 9);

	    // End of game
	    input.close();
	    System.out.println("The game has ended. Thank you for playing!");
	}
}
