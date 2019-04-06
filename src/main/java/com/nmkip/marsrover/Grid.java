package com.nmkip.marsrover;

import java.util.Collections;
import java.util.Set;

class Grid {

    private final int width;
    private final int height;
    private final Set<Coordinate> obstacles;

    Grid(int width, int height, Set<Coordinate> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = Collections.emptySet();
    }

    Coordinate moveTowards(Direction direction, Coordinate currentCoordinate) {
        Coordinate nextCoordinate = nextCoordinateFrom(currentCoordinate, direction);
        if (obstacles.contains(nextCoordinate)) {
            return currentCoordinate;
        }
        return nextCoordinate;
    }

    private Coordinate nextCoordinateFrom(Coordinate currentCoordinate, Direction direction) {
        int y = currentCoordinate.y();
        int x = currentCoordinate.x();

        switch (direction) {
            case NORTH:
                int nextY = (y + 1) % height;
                return new Coordinate(x, nextY);
            case EAST:
                int nextX = (x + 1) % width;
                return new Coordinate(nextX, y);
            case WEST:
                nextX = x == 0 ? width - 1 : x - 1;
                return new Coordinate(nextX, y);
            case SOUTH:
                nextY = y == 0 ? height - 1 : y - 1;
                return new Coordinate(x, nextY);
        }

        return currentCoordinate;
    }
}
