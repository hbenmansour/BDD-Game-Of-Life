package fr.xebia.training.tdd.gameoflife;

public class Cell {

    public static final boolean ALIVE = Boolean.TRUE;
    public static final boolean DEAD = Boolean.FALSE;

    private final Coordinate coordinate;
    private final Neighbourhood neighbourhood;

    private boolean currentState;

    private boolean nextState;

    public Cell(Universe universe, Coordinate coordinate) {
        this(coordinate, new Neighbourhood(universe, coordinate), DEAD);
    }

    public Cell(Universe universe, Coordinate coordinate, boolean initialState) {
        this(coordinate, new Neighbourhood(universe, coordinate), initialState);
    }

    /*package*/ Cell(Coordinate coordinate, Neighbourhood neighbourhood, boolean initialState) {
        this.coordinate = coordinate;
        this.neighbourhood = neighbourhood;
        this.currentState = initialState;
    }

    public Coordinate coordinate() {
        return this.coordinate;
    }

    public boolean isAlive() {
        return (this.currentState == ALIVE);
    }

    public boolean isDead() {
        return (this.currentState == DEAD);
    }

    public void computeNextState() {
        if (this.isAlive()) {
            computeNextStateWhenAlive();
        } else {
            computeNextStateWhenDead();
        }
    }

    public void commitNewState() {
        this.currentState = this.nextState;
    }

    private void computeNextStateWhenDead() {
        if (neighbourhood.liveCount() == 3) {
            this.nextState = ALIVE;
        } else {
            this.nextState = DEAD;
        }
    }

    private void computeNextStateWhenAlive() {
        int liveNeighbours = neighbourhood.liveCount();
        if (liveNeighbours < 2 || liveNeighbours > 3) {
            this.nextState = DEAD;
        } else {
            this.nextState = ALIVE;
        }
    }
}
