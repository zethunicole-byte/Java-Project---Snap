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

    public void playGame() {

        Scanner scanner = new Scanner(System.in);

        Card lastCard = null;

        boolean player1Turn = true;

        System.out.println("SNAP GAME START");

        while (deckOfCards.size() > 0) {

            Player currentPlayer;

            if (player1Turn == true) {
                currentPlayer = player1;
            } else {
                currentPlayer = player2;
            }

            System.out.println("\n" + currentPlayer.getName() + " press ENTER");
            scanner.nextLine();

            Card currentCard = dealCard();

            System.out.println(currentPlayer.getName() + " got: " + currentCard);

            if (lastCard != null) {

                if (currentCard.getSymbol().equals(lastCard.getSymbol())) {

                    System.out.println("\nSNAP!");
                    System.out.println("Type SNAP within 2 seconds!");

                    boolean result = snapTimer();

                    if (result == true) {
                        System.out.println(currentPlayer.getName() + " wins!");
                    } else {
                        System.out.println("Too slow!");
                        System.out.println("Game over");
                    }

                    return;
                }
            }

            lastCard = currentCard;
            player1Turn = !player1Turn;
        }

        System.out.println("No snap happened");
    }

    public boolean snapTimer() {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {

            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        });

        try {

            String input = future.get(2, TimeUnit.SECONDS);

            if (input.equalsIgnoreCase("snap")) {
                return true;
            }

        } catch (Exception e) {
            return false;
        }

        executor.shutdownNow();
        return false;
    }
}