package com.nmkip.marsrover;

class MarsRover {

    String execute(String commands) {
        Direction direction = Direction.NORTH;
        Coordinate coordinate = new Coordinate(0, 0);

        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.toTheRight();
            } else if (command == 'L') {
                direction = direction.toTheLeft();
            } else {
                coordinate = coordinate.moveTowards(direction);
            }
        }

        return coordinate.x()
                + ":"
                + coordinate.y()
                + ":"
                + direction.value();
    }

    private class Coordinate {
        private static final int MAX_HEIGHT = 10;
        private static final int MAX_WIDTH = 10;

        private final int x;
        private final int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x() {
            return x;
        }

        int y() {
            return y;
        }

        Coordinate moveTowards(Direction direction) {
            switch (direction) {
                case NORTH:
                    int nextY = (y + 1) % MAX_HEIGHT;
                    return new Coordinate(x, nextY);
                case EAST:
                    int nextX = (x + 1) % MAX_WIDTH;
                    return new Coordinate(nextX, y);
                case WEST:
                    nextX = x == 0 ? MAX_WIDTH - 1 : x - 1;
                    return new Coordinate(nextX, y);
                case SOUTH:
                    nextY = y == 0 ? MAX_HEIGHT - 1 : y - 1;
                    return new Coordinate(x, nextY);
            }
            return null;
        }
    }
}
