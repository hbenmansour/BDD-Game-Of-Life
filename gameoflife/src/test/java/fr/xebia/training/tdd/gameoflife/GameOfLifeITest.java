package fr.xebia.training.tdd.gameoflife;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameOfLifeITest {

    @Test
    public void dead_after_one_round_game() {
        int size = 3;
        Coordinate[] initialState = new Coordinate[]{
                new Coordinate(0, 0)
        };
        Coordinate[] expectedState = new Coordinate[]{};

        Universe board = createBoard(size, initialState);
        runAndVerify(board, expectedState);
    }

    @Test
    public void simple_game() {
        int size = 3;
        Coordinate[] initialState = new Coordinate[]{
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(0, 2)
        };
        Coordinate[] expectedState = new Coordinate[]{
                new Coordinate(0, 1),
                new Coordinate(1, 1)
        };

        Universe board = createBoard(size, initialState);
        runAndVerify(board, expectedState);
    }

    @Test
    public void still_game() {
        int size = 3;
        Coordinate[] initialState = new Coordinate[]{
                new Coordinate(1, 0),
                new Coordinate(2, 1),
                new Coordinate(1, 1),
                new Coordinate(2, 1)
        };

        Universe board = createBoard(size, initialState);
        runAndVerify(board, initialState);
    }

    @Test
    public void another_still_game() {
        int size = 4;
        Coordinate[] initialState = new Coordinate[]{
                new Coordinate(0, 1),
                new Coordinate(0, 2),
                new Coordinate(1, 0),
                new Coordinate(1, 3),
                new Coordinate(2, 1),
                new Coordinate(2, 2)
        };

        Universe board = createBoard(size, initialState);
        runAndVerify(board, initialState);
    }

    @Test
    public void oscillator_game() {
        int size = 3;
        Coordinate[] initialState = new Coordinate[]{
                new Coordinate(0, 1),
                new Coordinate(1, 1),
                new Coordinate(2, 1)
        };
        Coordinate[] expectedState = new Coordinate[]{
                new Coordinate(1, 0),
                new Coordinate(1, 1),
                new Coordinate(1, 2)
        };

        Universe board = createBoard(size, initialState);
        runAndVerify(board, expectedState);
        runAndVerify(board, initialState);
    }

    @Test
    public void another_oscillator_game() {
        int size = 4;
        Coordinate[] initialState = new Coordinate[]{
                new Coordinate(0, 1),
                new Coordinate(1, 1),
                new Coordinate(1, 2),
                new Coordinate(2, 1),
                new Coordinate(2, 2),
                new Coordinate(3, 2)
        };
        Coordinate[] expectedState = new Coordinate[]{
                new Coordinate(0, 1),
                new Coordinate(0, 2),
                new Coordinate(1, 0),
                new Coordinate(2, 3),
                new Coordinate(3, 1),
                new Coordinate(3, 2)
        };

        Universe board = createBoard(size, initialState);
        runAndVerify(board, expectedState);
        runAndVerify(board, initialState);
    }


    protected Universe createBoard(int size, Coordinate[] initialState) {
        Universe board = new Board(size, initialState);
        return board;
    }

    private Universe runAndVerify(Universe board, Coordinate[] expectedState) {
        board.update();
        Set<Coordinate> liveCells = board.liveCells();
        assertEquals(expectedState.length, liveCells.size());
        assertTrue(liveCells.containsAll(Arrays.asList(expectedState)));
        return board;
    }

}
