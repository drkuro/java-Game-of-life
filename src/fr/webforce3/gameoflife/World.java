package fr.webforce3.gameoflife;

import java.util.Random;

import fr.webforce3.gameoflife.entity.AliveCell;
import fr.webforce3.gameoflife.entity.Cell;
import fr.webforce3.gameoflife.entity.DeadCell;

public class World {
	private Cell[][] world;
    private int nbColumns;
    private int nbRows;
    private int generation;

    public World(int nbColumns, int nbRows) {
        this.nbColumns = nbColumns;
        this.nbRows = nbRows;
        this.generation = 0;
        this.world = new Cell[nbColumns][nbRows];
        initializeRandomWorld();
    }

    public World(Cell[][] world) {
        this.nbColumns = world.length;
        this.nbRows = world[0].length;
        this.generation = 0;
        this.world = world;
    }

    private void initializeRandomWorld() {
        Random random = new Random();
        for (int i = 0; i < nbColumns; i++) {
            for (int j = 0; j < nbRows; j++) {
            	world[i][j] = random.nextBoolean() ? 
            			new AliveCell() : new DeadCell();
            }
        }
    }

    public void newGeneration() {
        Cell[][] newWorld = new Cell[nbColumns][nbRows];
        for (int i = 0; i < nbColumns; i++) {
            for (int j = 0; j < nbRows; j++) {
                int nbNeighbours = countAliveNeighbours(i, j);
                newWorld[i][j] = world[i][j].newGeneration(nbNeighbours);
            }
        }
        world = newWorld;
        generation++;
    }

    private int countAliveNeighbours(int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < nbColumns 
                		&& j >= 0 && j < nbRows 
                		&& !(i == x && j == y) 
                		&& world[i][j].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Generation: ").append(generation).append("\n");
        for (int i = 0; i < nbColumns; i++) {
            for (int j = 0; j < nbRows; j++) {
                sb.append(world[i][j].getAsString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}