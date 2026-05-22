package org.example;

import java.util.Scanner;
import java.util.concurrent.*;

public class Snap extends CardGame {

    private Player player1;
    private Player player2;

    public Snap(String name, Player p1, Player p2) {

        super(name);

        this.player1 = p1;
        this.player2 = p2;

        shuffleDeck();
    }
