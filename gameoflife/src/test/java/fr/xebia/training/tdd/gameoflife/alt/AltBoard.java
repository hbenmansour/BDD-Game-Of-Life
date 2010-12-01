package fr.xebia.training.tdd.gameoflife.alt;

import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.Universe;

import java.util.HashSet;
import java.util.Set;

public class AltBoard implements Universe {

    private boolean[][] grid;
    private int size;

    public AltBoard(int size, Coordinate[] initialState) {
        assert size > 0;
        this.size = size;
        this.grid = new boolean[size][size];
        for (Coordinate coordinate : initialState) {
            int x = coordinate.toIntArray()[0];
            int y = coordinate.toIntArray()[1];
            if (isInBound(x, y)) {
                grid[x][y] = true;
            }
        }
    }

    private boolean isInBound(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    public int liveCellsCount() {
        return liveCells().size();
    }

    public int deadCellsCount() {
        return (size * size) - liveCellsCount();
    }

    public Set<Coordinate> liveCells() {
        Set<Coordinate> liveCells = new HashSet<Coordinate>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j]) liveCells.add(new Coordinate(i, j));
            }
        }
        return liveCells;
    }

    public boolean isAlive(Coordinate coordinate) {
        int x = coordinate.toIntArray()[0];
        int y = coordinate.toIntArray()[1];
        return isInBound(x, y) && grid[x][y];
    }

    public void update() {
        boolean[][] newGrid = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int liveNeighbours = countLiveNeighbours(i, j);
                if (!grid[i][j]) {
                    if (liveNeighbours == 3) {
                        newGrid[i][j] = true;
                    }
                } else if (liveNeighbours == 2 || liveNeighbours == 3) {
                    newGrid[i][j] = true;
                }
            }
        }
        this.grid = newGrid;
    }

    private int countLiveNeighbours(int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int xx = x + i;
                int yy = y + j;
                if (isInBound(xx, yy) && grid[xx][yy]) count++;
            }
        }
        if (grid[x][y]) count--;
        return count;
    }
}
