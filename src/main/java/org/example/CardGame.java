import java.util.ArrayList;

public class CardGame {

    private ArrayList<Card> deckOfCards;
    private String name;

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        createDeck();
    }