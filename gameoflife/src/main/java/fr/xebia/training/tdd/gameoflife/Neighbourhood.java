package fr.xebia.training.tdd.gameoflife;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Neighbourhood {

    private final Set<Coordinate> neighbours;
    private final Universe universe;

    public Neighbourhood(Universe universe, Coordinate my) {
        this.universe = universe;
        this.neighbours = Collections.unmodifiableSet(computeNeighbours(my));
    }

    private Set<Coordinate> computeNeighbours(final Coordinate center) {
        Set<Coordinate> coordinatesOfNeighbours = new HashSet<Coordinate>();
        coordinatesOfNeighbours.add(center.left());
        coordinatesOfNeighbours.add(center.left().top());
        coordinatesOfNeighbours.add(center.left().bottom());
        coordinatesOfNeighbours.add(center.top());
        coordinatesOfNeighbours.add(center.bottom());
        coordinatesOfNeighbours.add(center.right());
        coordinatesOfNeighbours.add(center.right().top());
        coordinatesOfNeighbours.add(center.right().bottom());
        return coordinatesOfNeighbours;
    }

    public int liveCount() {
        int count = 0;
        for (Coordinate coordinate : neighbours) {
            if (universe.isAlive(coordinate)) count++;
        }
        return count;
    }

    /*package*/ int neighboursCount() {
        return neighbours.size();
    }

}
