package fr.xebia.training.tdd.gameoflife;

import java.util.Set;

public interface Universe {

    int liveCellsCount();

    int deadCellsCount();

    Set<Coordinate> liveCells();

    boolean isAlive(Coordinate coordinate);

    void update();

}
