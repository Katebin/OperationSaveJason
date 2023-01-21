package Components.Players;
import java.util.Scanner;

public class HumanPlayer extends Player{
    private final Scanner inputScanner = new Scanner(System.in); // remains one declaration, avoids resource waste
    public int chips;

    public HumanPlayer(String name, boolean isDealer) {
        super(name, isDealer);
    }

    @Override
    public void bet() {
        // collect player bet
        String userInput;

        if(isDealer == false) {
            System.out.println("\nSelect one of the following bets" + "\n1. 5 chips" + "\n2. 10 chips" + "\n3. 15 chips");
            userInput = inputScanner.nextLine().toLowerCase();

            // repeat until valid input
            while(userInput.equals("5") != true && userInput.equals("10") != true && userInput.equals("15") != true ) {
                System.out.println(":: Operation failed ::\n" + "Select one of the following bets" + "\n1. 5 chips" + "\n2. 10 chips" + "\n3. 15 chips");
                userInput = inputScanner.nextLine().toLowerCase();
            }

            // update bet
            bet = Integer.parseInt(userInput);
            chips -= bet;
        }
    }

    @Override
    public String getMove() {
        // gets the players move, game receives console input
        String userInput;

        System.out.println("\nPlease select a move (with its name):" + "\n" + "1. Hit" + "\n" + "2. Stand");
        userInput = inputScanner.nextLine().toLowerCase();

        // repeat until valid input
        while(userInput.equals("hit") != true && userInput.equals("stand") != true) {
            System.out.println(":: Operation failed ::\n" + "Please select a move (with its name): " + "\n" + "1. Hit" + "\n" + "2. Stand");
            userInput = inputScanner.nextLine().toLowerCase();
        }

        return userInput;
    }
}
