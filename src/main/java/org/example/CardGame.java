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

    // Deal top card
    public Card dealCard() {

        Card topCard = deckOfCards.getFirst();

        deckOfCards.removeFirst();

        return topCard;
    }

    // This method sorts the deck of cards in ascending numerical order (lowest to highest).
    // Collections.sort() sorts the list.
    // The Comparator defines the sorting rules by comparing two cards at a time (c1 and c2).
    // c1.getValue() - c2.getValue() returns a negative number if c1 is smaller,
    // zero if they are equal, or a positive number if c1 is larger.
   // smaller card first, sorting the deck from lowest to highest value.

        public ArrayList<Card> sortDeckInNumberOrder() {

        deckOfCards.sort(new Comparator<Card>() {

            @Override
            public int compare(Card c1, Card c2) {

                return c1.getValue() - c2.getValue();
            }
        });
            return deckOfCards;
        }

    // This method sorts the deck of cards first by suit, then by value within each suit.
    // Collections.sort() sorts the list for me.
    // The Comparator defines the sorting rules by comparing two cards at a time (c1 and c2).
    // c1.getSuit().compareTo(c2.getSuit()) compares the suits alphabetically,
    // returning a negative number, zero, or positive number just like the number sort.
    // If suitCompare == 0, it means both cards have the same suit,
    // so we then sort by value using c1.getValue() - c2.getValue() (lowest to highest).
    // If the suits are different, we return suitCompare to sort by suit first.

    // This method shuffles the deck into a random order.
    // Collections.shuffle() randomly rearranges the list for me.
    public ArrayList<Card> sortDeckIntoSuits() {

        deckOfCards.sort(new Comparator<Card>() {

            @Override
            public int compare(Card c1, Card c2) {

                // Compare suit first
                int suitCompare = c1.getSuit().compareTo(c2.getSuit());

                // If same suit compare value
                if (suitCompare == 0) {
                    return c1.getValue() - c2.getValue();
                }

                return suitCompare;
            }
        });

        return deckOfCards;
    }

    // Shuffle deck
    public ArrayList<Card> shuffleDeck() {

        Collections.shuffle(deckOfCards);

        return deckOfCards;
    }
 }