package fr.webforce3.gameoflife.entity;


/**
 * AliveCell is a type of cell that represents a live cell.
 * Implements the Cell interface and the methods defined in it.
 */
public class AliveCell implements Cell {
    private boolean isNewBorn = true;

    @Override
    public Cell newGeneration(int nbNeighbours) {
        // According to Conway's Game of Life, a live cell with 2 or 3 live neighbours survives.
        // Otherwise, it dies due to under-population or over-population.
        if(nbNeighbours < 2 || nbNeighbours > 3) {
            return new DeadCell();
        }
        this.isNewBorn = false;
        return this;
    }

    @Override
    public String getAsString() {
        // Represents a new born cell with '0' and other alive cells with '+'.
        return isNewBorn ? "0" : "+";
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}