package fr.xebia.training.tdd.gameoflife;


import org.junit.Test;
import org.mockito.InOrder;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BoardTest {

    @Test
    public void new_board_should_have_only_dead_cells() throws Exception {
        int size = 3;
        Universe board = new Board(3);
        assertEquals(size * 3, board.deadCellsCount());
    }

    @Test
    public void board_initialized_with_3_live_cells_should_have_3_live_cells() throws Exception {
        Universe board = new Board(3, new Coordinate(0, 0), new Coordinate(0, 1), new Coordinate(0, 2));
        assertEquals(3, board.liveCellsCount());
    }

    @Test
    public void board_initialized_with_1_live_cells_should_have_this_cell_alive() throws Exception {
        Board board = new Board(5, new Coordinate(3, 4));
        assertTrue(board.isAlive(3, 4));
    }

    @Test
    public void board_initialized_with_1_live_cell_should_have_other_cells_dead() throws Exception {
        int size = 5;
        Board board = new Board(size, new Coordinate(3, 4));
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (x != 3 && y != 4) {
                    assertFalse(board.isAlive(x, y));
                }
            }
        }
    }

    @Test
    public void updating_the_board_should_update_then_commit_each_cell() {
        int boardSize = 2;
        Map<Coordinate, Cell> cells = new HashMap<Coordinate, Cell>();
        Cell cell = mock(Cell.class);
        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                cells.put(new Coordinate(x, y), cell);
            }
        }
        Universe board = new Board(cells);
        board.update();
        InOrder inOrder = inOrder(cell);
        inOrder.verify(cell, times(boardSize * boardSize)).computeNextState();
        inOrder.verify(cell, times(boardSize * boardSize)).commitNewState();
    }

    @Test
    public void cell_outside_board_should_be_dead() {
        Board board = new Board(3);
        assertFalse(board.isAlive(0, -1));
        assertFalse(board.isAlive(0, 3));
    }

}
