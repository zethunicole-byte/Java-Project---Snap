package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {

    // Variables
    protected ArrayList<Card> deckOfCards;
    private String name;

    // Constructor
    public CardGame(String name) {

        this.name = name;

        deckOfCards = new ArrayList<>();

        // Arrays for suits and symbols
        String[] suits = {"♥", "♦", "♣", "♠"};
        String[] symbols = {
                "2", "3", "4", "5", "6", "7",
                "8", "9", "10", "J", "Q", "K", "A"
        };

        int value = 2;

        for (String suit : suits) {

            value = 2;

            for (String symbol : symbols) {

                Card card = new Card(suit, symbol, value);

                deckOfCards.add(card);

                value++;
            }
        }
    }

    // Show deck
        public void getDeck() {

        for (Card card : deckOfCards) {
            System.out.println(card);
        }
     }
