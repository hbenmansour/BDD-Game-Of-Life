package fr.xebia.training.tdd.gameoflife;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CellTest {

    @Test
    public void new_cell_should_be_dead() throws Exception {
        Cell cell = new Cell(null, new Coordinate(0, 0));
        assertTrue(cell.isDead());
    }

    @Test
    public void live_cell_with_no_live_neighbour_dies() throws Exception {
        Cell cell = createCellWithLiveNeighboors(0, Cell.ALIVE);
        computeAndCommitNextState(cell);
        assertFalse(cell.isAlive());
    }

    @Test
    public void live_cell_with_only_one_live_neighbour_dies() throws Exception {
        Cell cell = createCellWithLiveNeighboors(1, Cell.ALIVE);
        computeAndCommitNextState(cell);
        assertFalse(cell.isAlive());
    }

    @Test
    public void live_cell_with_2_live_neighbours_survives() throws Exception {
        Cell cell = createCellWithLiveNeighboors(2, Cell.ALIVE);
        computeAndCommitNextState(cell);
        assertTrue(cell.isAlive());
    }

    @Test
    public void live_cell_with_3_live_neighbours_survives() throws Exception {
        Cell cell = createCellWithLiveNeighboors(3, Cell.ALIVE);
        computeAndCommitNextState(cell);
        assertTrue(cell.isAlive());
    }

    @Test
    public void live_cell_with_4_live_neighbours_should_die() throws Exception {
        Cell cell = createCellWithLiveNeighboors(4, Cell.ALIVE);
        computeAndCommitNextState(cell);
        assertFalse(cell.isAlive());
    }

    @Test
    public void dead_cell_with_1_live_neighbours_remains_dead() throws Exception {
        Cell cell = createCellWithLiveNeighboors(1, Cell.DEAD);
        computeAndCommitNextState(cell);
        assertFalse(cell.isAlive());
    }

    @Test
    public void dead_cell_with_2_live_neighbours_remains_dead() throws Exception {
        Cell cell = createCellWithLiveNeighboors(2, Cell.DEAD);
        computeAndCommitNextState(cell);
        assertFalse(cell.isAlive());
    }

    @Test
    public void dead_cell_with_3_live_neighbours_should_come_to_life() throws Exception {
        Cell cell = createCellWithLiveNeighboors(3, Cell.DEAD);
        computeAndCommitNextState(cell);
        assertTrue(cell.isAlive());
    }

    @Test
    public void uncommited_reborn_cell_should_stay_dead() throws Exception {
        Cell cell = createCellWithLiveNeighboors(3, Cell.DEAD);
        cell.computeNextState();
        assertFalse(cell.isAlive());
    }

    private Cell createCellWithLiveNeighboors(int liveNeighboorsCount, boolean initialState) {
        Coordinate coordinate = new Coordinate(0, 0);
        Neighbourhood neighbourhood = mock(Neighbourhood.class);
        when(neighbourhood.liveCount()).thenReturn(liveNeighboorsCount);
        return new Cell(coordinate, neighbourhood, initialState);
    }

    private void computeAndCommitNextState(Cell cell) {
        cell.computeNextState();
        cell.commitNewState();
    }
}
