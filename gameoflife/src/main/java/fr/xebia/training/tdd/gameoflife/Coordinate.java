package fr.xebia.training.tdd.gameoflife;

public class Coordinate {

    protected final int x;
    protected final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate left() {
        return new Coordinate(x - 1, y);
    }

    public Coordinate right() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate top() {
        return new Coordinate(x, y + 1);
    }

    public Coordinate bottom() {
        return new Coordinate(x, y - 1);
    }

    public int[] toIntArray() {
        return new int[]{x, y};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || other.getClass() != getClass())
            return false;
        return this.x == ((Coordinate) other).x && this.y == ((Coordinate) other).y;
    }

}
