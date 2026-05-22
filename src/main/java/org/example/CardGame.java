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


