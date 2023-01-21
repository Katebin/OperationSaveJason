package Components;
import Components.Players.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {
    private Player[] players;
    private int roundNum = 0;
    private ArrayList<Cards> currentDeck = new ArrayList<Cards>();

    public Game(Player[] players) {
        // list of players
        this.players = players;
    }

    private ArrayList<Cards> createDeck(int numOfCard) {
        // creates a deck out of the defined cards
        ArrayList<Cards> deck = new ArrayList<Cards>();

        for(Cards cardType : Cards.values()) {
            for(int i = 0; i < numOfCard; i++) { // repeat for num of cards
                deck.add(cardType);
            }
        }

        return deck;
    }

    private ArrayList<Cards> createShuffledDeck(int numOfCards) {
        // create a shuffled deck of cards
        ArrayList<Cards> deck = createDeck(numOfCards);
        Collections.shuffle(deck);

        return deck;
    }

    private void dealCard(Player player) {
        if(currentDeck.size() > 0) { // ensure no errors if deck has exhausted cards
            player.hand.add(currentDeck.get(0)); // add to the players hand
            currentDeck.remove(0);
        } else { // if no cards, get new deck
            System.out.println(":: New Deck Opened ::");
            currentDeck = createShuffledDeck(4); // 52 cards
            player.hand.add(currentDeck.get(0)); // add to the players hand
            currentDeck.remove(0);
        }

    }

    private void collectBets() {
        System.out.println("Round " + roundNum + " has now begun, players please place your bets");

        // betting phase
        for(Player player : players) {
            if(player.isDealer != true) { // skip dealers
                player.bet();
                System.out.println(player.name + " bets: " + player.bet + " coins!");
            }
        }
    }

    private void printChipScoreboard() {
        // print the amount of chips each player has
        System.out.println("\n:: The current amount of chips are ::");
        for(Player player : players) {
            System.out.println("| " + player.name + "'s chips: " + player.chips);
        }
    }

    public void playRound() {
        // plays a round of the game
        String currentMove;
        int counter = 0;
        ArrayList<Player> activePlayers = new ArrayList<>(Arrays.asList(players));
        ArrayList<Player> failedPlayers = new ArrayList<Player>();

        roundNum += 1; // update roundNum
        collectBets();

            for (Player player : activePlayers) {
                // get the move, inform players
                currentMove = player.getMove();
                System.out.println(player.name + " performed " + currentMove + "!");

                // handle actions
                switch (currentMove) {
                    case "hit":
                        dealCard(player);
                        System.out.println(player.name + " has a hand total of: " + player.handTotal());
                        break;
                    case "stand":
                        System.out.println(player.name + " has a hand total of: " + player.handTotal());
                        break;
                    default: // in event of failure skip
                        break;
                }

                if (player.handTotal() > 21) {
                    // if loss, get out of here
                    System.out.println(player.name + " has busted!");
                    failedPlayers.add(player);
                }
            }

            // remove failed player, perform in upper loop
            for(Player failure : failedPlayers) {
                activePlayers.remove(failure);
            }

            for (Player player : activePlayers) {
                if (player.isDealer == true) {
                    for (Player failure : failedPlayers) { // give failures bets to dealer
                        player.chips += failure.bet;
                        counter += failure.bet;
                        failure.bet = 0;
                    }

                    System.out.println("Dealer has taken " + counter + " chips!");
                    counter = 0;

                } else {
                    player.chips += (player.bet * 2);
                    System.out.println(player.name + " now has " + player.chips + " chips!");
                    player.bet = 0;
                }
            }

            // print scoreboard
            printChipScoreboard();

            if(activePlayers.size() == 1)  {
            System.out.println("Game over!");
            System.exit(0); // end program
        }
    }
}
