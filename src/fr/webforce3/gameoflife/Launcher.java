package fr.webforce3.gameoflife;

public class Launcher {
    public static void mains(String[] args) {
        int nbColumns = 10; // Number of columns in the world
        int nbRows = 10; // Number of rows in the world

        // Create a new world with random initial state
        World world = new World(nbColumns, nbRows);

        // Print the initial state of the world
        System.out.println("Initial state:");
        System.out.println(world);

        // Iterate through generations
        for (int i = 1; i <= 10; i++) {
            world.newGeneration();
            System.out.println(world);
        }
    }
}