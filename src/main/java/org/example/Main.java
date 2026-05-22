package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        Player p1 = new Player(scanner.nextLine());

        System.out.print("Enter Player 2 name: ");
        Player p2 = new Player(scanner.nextLine());

        Snap game = new Snap("Snap", p1, p2);

        game.playGame();
    }
}