package Components.Players;

public class CpuPlayer extends Player {
    // I am an extremely basic opponent, child of the Player class
    public int chips;

    public CpuPlayer(String name, boolean isDealer) {
        super(name, isDealer);
    }

    @Override
    public void bet() {
        // collect basic bet
        if(isDealer == false) {
            // to be changed later
            bet = 5;
            chips -= 5;
        }
    }

    @Override
    public String getMove() {
        // basic opponent, returns its move
        if(handTotal() < 21) {
            return "hit";
        } else {
            return "stand";
        }
    }
}
