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


