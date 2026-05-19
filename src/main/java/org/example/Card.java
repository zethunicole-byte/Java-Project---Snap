package org.example;

public class Card {

    private String suit;
    private String symbol;
    private int value;

    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return symbol + suit + " (Value: " + value + ")";
    }


    // create a class called Card
    // Create variables with the card's data - protect the data with private
    // inside constructor "take the suit passed in and store it in this card"
    // getters because the variables are private
    // Override to string because Java would print it out as weird text