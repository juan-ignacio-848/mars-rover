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
        private int x;
        private int y;

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
                    return new Coordinate(0, y + 1);
                case EAST:
                    return new Coordinate(x + 1, 0);
            }
            return null;
        }
    }
}
