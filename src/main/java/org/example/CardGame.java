package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    protected ArrayList<Card> deckOfCards;
    protected String name;

    public CardGame(String name) {

        this.name = name;
        deckOfCards = new ArrayList<>();

        createDeck();
    }

    private void createDeck() {

        String[] symbols = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "J", "Q", "K", "A"
        };

        for (Suit suit : Suit.values()) {

            int value = 2;

            for (String symbol : symbols) {

                deckOfCards.add(
                        new Card(suit, symbol, value)
                );

                value++;
            }
        }
    }

    public void getDeck() {

        for (Card card : deckOfCards) {
            System.out.println(card);
        }
    }

    public Card dealCard() {

        if (deckOfCards.isEmpty()) {
            return null;
        }

        return deckOfCards.removeFirst();
    }
    public ArrayList<Card> sortDeckInNumberOrder() {

        deckOfCards.sort(
                Comparator.comparingInt(Card::getValue)
        );

        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {

        deckOfCards.sort((c1, c2) -> {

            int suitCompare =
                    c1.getSuit().ordinal()
                            - c2.getSuit().ordinal();

            if (suitCompare == 0) {
                return c1.getValue() - c2.getValue();
            }

            return suitCompare;
        });

        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {

        Collections.shuffle(deckOfCards);

        return deckOfCards;
    }
}




