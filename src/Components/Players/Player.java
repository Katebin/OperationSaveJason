package Components.Players;
import Components.Cards;
import java.util.ArrayList;

public abstract class Player {
    public ArrayList<Cards> hand = new ArrayList<Cards>();
    public final boolean isDealer;
    public final String name;
    public int chips = 15;
    public int bet;

    public Player(String name, boolean isDealer) {
        this.name = name;
        this.isDealer = isDealer;
    }

    public int handTotal() {
        // count value of hand
        int sum = 0;
        for (Cards card : hand) {
            sum += card.value;
        }

        return sum;
    }

    public abstract void bet(); // abstract method, defined by other classes
    public abstract String getMove(); // abstract method, defined by other classes
}
