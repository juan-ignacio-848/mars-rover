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

}
