package fr.xebia.training.tdd.gameoflife;

import java.util.*;

public class Board implements Universe {

    private Map<Coordinate, Cell> cells = new HashMap<Coordinate, Cell>();

    private final int size;

    public Board(int size, Coordinate... initialLiveCells) {
        this.size = size;
        buildCells(initialLiveCells);

    }

    /*package*/ Board(Map<Coordinate, Cell> cells) {
        this.size = (int) Math.sqrt(cells.size());
        this.cells = cells;
    }

    public synchronized void update() {
        computeNextStatusForEachCell();
        commitNewStatusForEachCell();
    }

    public Set<Coordinate> liveCells() {
        final Set<Coordinate> liveCells = new HashSet<Coordinate>();
        forEachCell(new Board.CellProcessor() {
            public void process(Cell cell) {
                if (cell.isAlive()) {
                    liveCells.add(cell.coordinate());
                }
            }
        });
        return Collections.unmodifiableSet(liveCells);
    }

    public int liveCellsCount() {
        return liveCells().size();
    }

    public int deadCellsCount() {
        return cells.size() - liveCellsCount();
    }

    private void commitNewStatusForEachCell() {
        forEachCell(new CellProcessor() {
            public void process(Cell cell) {
                cell.commitNewState();
            }
        });
    }

    private void computeNextStatusForEachCell() {
        forEachCell(new CellProcessor() {
            public void process(Cell cell) {
                cell.computeNextState();
            }
        });
    }

    public synchronized boolean isAlive(int x, int y) {
        return isAlive(new Coordinate(x, y));
    }

    public synchronized boolean isAlive(Coordinate coordinate) {
        Cell cell = cells.get(coordinate);
        return cell != null && cell.isAlive();
    }

    private synchronized void forEachCell(final CellProcessor visitor) {
        for (Cell cell : cells.values()) {
            visitor.process(cell);
        }
    }

    private void buildCells(Coordinate... initialLiveCells) {
        List<Coordinate> initialCoordinates = Arrays.asList(initialLiveCells);
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Coordinate coordinate = new Coordinate(x, y);
                boolean initialState = initialCoordinates.contains(coordinate) ? Cell.ALIVE : Cell.DEAD;
                Cell cell = new Cell(this, coordinate, initialState);
                cells.put(coordinate, cell);
            }
        }
    }

    private static interface CellProcessor {
        void process(final Cell cell);
    }
}