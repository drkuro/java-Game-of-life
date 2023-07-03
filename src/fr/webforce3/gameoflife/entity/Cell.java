package fr.webforce3.gameoflife.entity;


/**
 * Cell interface that defines the basic cell operations.
 */
public interface Cell {
    // Determines the state of the cell in the next generation based on the number of live neighbours.
    Cell newGeneration(int nbNeighbours);
    
    // Returns a string representation of the cell's state.
    String getAsString();
    
    // Returns whether the cell is currently alive or not.
    boolean isAlive();
}