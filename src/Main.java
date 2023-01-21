import Components.Game;
import Components.Players.CpuPlayer;
import Components.Players.HumanPlayer;
import Components.Players.Player;

public class Main {
    public static void main(String[] args) {
        // all relevant code located in /Components
        // Player list can be changed manually, add as many players as wanted
        Player[] players = {
                new HumanPlayer("Jason", false),
                new CpuPlayer("TheEpicKatebin", false),
                new CpuPlayer("Dealer", true)
        };

        Game game = new Game(players); // initiate a game

        // play one game, infinite while loop enables dynamically timed games
        // you can increase the number of games per execution by changing the values of this forloop
        for(int games = 0; games < 2; games++) {
            while (1 == 1) {
                game.playRound();
            }
        }
    }
}