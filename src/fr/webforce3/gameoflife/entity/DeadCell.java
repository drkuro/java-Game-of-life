package fr.webforce3.gameoflife.entity;


/**
 * DeadCell is a type of cell that represents a dead cell.
 * Implements the Cell interface and the methods defined in it.
 */
public class DeadCell implements Cell {
    @Override
    public Cell newGeneration(int nbNeighbours) {
        // According to Conway's Game of Life, a dead cell with exactly 3 live neighbours becomes a live cell.
        if(nbNeighbours == 3) {
            return new AliveCell();
        }
        // If not, it remains dead.
        return this;
    }

    @Override
    public String getAsString() {
        // Represents a dead cell with a '-'.
        return "-";
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}