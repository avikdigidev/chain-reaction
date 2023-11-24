package com.prakash.chain.reaction;

import com.prakash.chain.reaction.model.Board;
import com.prakash.chain.reaction.model.Player;

import java.util.Scanner;

public class GameManager {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;

    public GameManager(int gridSize, int numPlayers) {
        board = new Board(gridSize);
        players = new Player[numPlayers];
        // Initialize players
        // Set currentPlayerIndex
    }




    public boolean isGameFinished() {
        int remainingPlayers = 0;

        for (int i = 0; i < numPlayers; i++) {
            remainingPlayers += isPlayerRemaining(i + 1) ? 1 : 0;
        }

        return remainingPlayers == 1;
    }

    private boolean isPlayerRemaining(int player) {
        // Check if the player has remaining orbs on the grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayGrid() {
        System.out.println("Current Grid:");

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("_ "); // Print underscore for empty cells
                } else {
                    System.out.print(playerColors[grid[i][j] - 1] + " ");
                }
            }
            System.out.println();
        }
    }

    public void playTurn(int player) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row to place orb: ");
        int row = scanner.nextInt();

        System.out.print("Enter column to place orb: ");
        int col = scanner.nextInt();

        if (grid[row][col] == 0 || grid[row][col] == player + 1) {
            grid[row][col] = player + 1; // Assigning player number to the cell
        } else {
            System.out.println("Invalid move. Cell is occupied by another player.");
            playTurn(player); // Retry turn
        }

        // Trigger chain reactions if the cell has reached its capacity
        if (grid[row][col] == player + 1) {
            if (checkExplode(row, col)) {
                explodeCell(row, col);
            }
        }
    }

    // Method to check if the cell has reached its capacity
    private boolean checkExplode(int row, int col) {
        return countAdjacentOrbs(row, col) >= 4;
    }

    // Method to count orbs in adjacent cells
    private int countAdjacentOrbs(int row, int col) {
        int count = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValidCell(newRow, newCol) && grid[newRow][newCol] != 0) {
                count++;
            }
        }
        return count;
    }

    // Method to check if a cell is valid (within grid bounds)
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < gridSize && col >= 0 && col < gridSize;
    }

    // Method to explode the cell and distribute orbs to adjacent cells
    private void explodeCell(int row, int col) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValidCell(newRow, newCol)) {
                grid[newRow][newCol]++;
                if (checkExplode(newRow, newCol)) {
                    explodeCell(newRow, newCol);
                }
            }
        }

        grid[row][col] = 0; // Reset the exploded cell to empty
    }
}
