package com.prakash.chain.reaction;

import java.util.Scanner;

public class AppMain {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid size: ");
        int gridSize = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        ChainReactionGame game = new ChainReactionGame(gridSize, numPlayers);
        game.initializeGame();

        while (!game.isGameFinished()) {
            for (int i = 0; i < numPlayers; i++) {
                game.displayGrid();
                System.out.println("Player " + (i + 1) + "'s turn.");
                game.playTurn(i);
            }
        }

        int winner = 0;
        for (int i = 0; i < numPlayers; i++) {
            if (game.isPlayerRemaining(i + 1)) {
                winner = i + 1;
                break;
            }
        }

        System.out.println("Player " + winner + " wins!");
        scanner.close();
    }



}
