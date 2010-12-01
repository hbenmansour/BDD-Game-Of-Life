package fr.xebia.training.tdd.gameoflife.alt;

import fr.xebia.training.tdd.gameoflife.Coordinate;
import fr.xebia.training.tdd.gameoflife.GameOfLifeITest;
import fr.xebia.training.tdd.gameoflife.Universe;


public class AltGameOfLifeITest extends GameOfLifeITest {

    @Override
    protected Universe createBoard(int size, Coordinate[] initialState) {
        return new AltBoard(size, initialState);
    }


}
