package com.prakash.chain.reaction;

import java.util.Scanner;

public class ChainReactionGame {
    private int[][] grid;
    private int gridSize;
    private int numPlayers;
    private char[] playerColors;

    public ChainReactionGame(int gridSize, int numPlayers) {
        this.gridSize = gridSize;
        this.numPlayers = numPlayers;
        this.grid = new int[gridSize][gridSize];
        this.playerColors = new char[]{'R', 'G', 'B', 'Y', 'M', 'C'};
    }

    public void initializeGame() {
        //bydefault the grid would be empty
    }
}

