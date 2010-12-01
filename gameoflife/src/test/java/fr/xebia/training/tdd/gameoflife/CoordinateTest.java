package fr.xebia.training.tdd.gameoflife;

import org.junit.Test;

import static junit.framework.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;

public class CoordinateTest {

    @Test
    public void coordinate_1_1_should_equal_1_1() {
        Coordinate given = new Coordinate(1, 1);
        Coordinate expected = new Coordinate(1, 1);
        assertEquals(expected, given);
    }

    @Test
    public void coordinate_1_1_should_not_equal_1_0() {
        Coordinate given = new Coordinate(1, 1);
        Coordinate expected = new Coordinate(1, 0);
        assertNotSame(expected, given);
    }

    @Test
    public void left_of_1_1_should_be_0_1() {
        Coordinate given = new Coordinate(1, 1);
        Coordinate expected = new Coordinate(0, 1);
        assertEquals(expected, given.left());
    }

    @Test
    public void right_of_1_1_should_be_2_1() {
        Coordinate given = new Coordinate(1, 1);
        Coordinate expected = new Coordinate(2, 1);
        assertEquals(expected, given.right());
    }

    @Test
    public void top_of_1_1_should_be_1_2() {
        Coordinate given = new Coordinate(1, 1);
        Coordinate expected = new Coordinate(1, 2);
        assertEquals(expected, given.top());
    }

    @Test
    public void bottom_of_1_1_should_be_1_0() {
        Coordinate given = new Coordinate(1, 1);
        Coordinate expected = new Coordinate(1, 0);
        assertEquals(expected, given.bottom());
    }


}
