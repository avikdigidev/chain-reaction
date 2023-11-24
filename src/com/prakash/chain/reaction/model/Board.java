package com.prakash.chain.reaction.model;

public class Board {
    private Cell[][] cells;
    private int gridSize;

    public Board(int gridSize) {
        this.gridSize = gridSize;
        cells = new Cell[gridSize][gridSize];
        // Initialize cells
    }

    // Methods to interact with cells and perform operations on the board
}
