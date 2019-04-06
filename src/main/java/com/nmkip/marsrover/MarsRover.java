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
                coordinate = coordinate.moveUp();
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

        Coordinate moveUp() {
            return new Coordinate(0, y + 1);
        }
    }
}
