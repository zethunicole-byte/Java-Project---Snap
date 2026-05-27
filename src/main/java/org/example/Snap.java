package org.example;

import java.util.Scanner;
import java.util.Scanner;

public class Snap extends CardGame {

    private Player player1;
    private Player player2;

    public Snap(String name, Player p1, Player p2) {

        super(name);

        player1 = p1;
        player2 = p2;

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

            // Check for snap
            if (lastCard != null) {

                if (currentCard.getSymbol().equals(lastCard.getSymbol())) {

                    System.out.println("\nSNAP!");
                    System.out.println(currentPlayer.getName()
                            + " type SNAP within 10 seconds!");

                    try {


                        Thread.sleep(1000);

                    } catch (InterruptedException e) {

                        System.out.println("Timer error!");
                    }

                    long startTime = System.currentTimeMillis();

                    String input = scanner.nextLine();

                    long endTime = System.currentTimeMillis();

                    long totalTime = (endTime - startTime) / 1000;

                    if (input.equalsIgnoreCase("snap")
                            && totalTime <= 10) {

                        System.out.println(currentPlayer.getName()
                                + " wins!");

                    } else {

                        System.out.println("Too slow!");
                        System.out.println("Game Over!");
                    }

                    return;
                }
            }

            lastCard = currentCard;

            player1Turn = !player1Turn;
        }

        System.out.println("No snap happened");
    }
}