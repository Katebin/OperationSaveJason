package Components;

public enum Cards {
    // contains all the values of the cards,
    // enables easier customization and the addition of more cards without error
    // *these are glorified constants*
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    KING(13),
    QUEEN(12),
    JACK(11),
    ACE(1);

    public final int value;

    private Cards(int value) {
        this.value = value;
    }
}
