package com.nmkip.marsrover;

class MarsRover {

    private Grid grid;

    MarsRover(Grid grid) {
        this.grid = grid;
    }

    String execute(String commands) {
        Direction direction = Direction.NORTH;
        Coordinate coordinate = new Coordinate(0, 0);
        Coordinate lastCoordinate = null;
       
        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.toTheRight();
            } else if (command == 'L') {
                direction = direction.toTheLeft();
            } else {
                lastCoordinate = coordinate;
                coordinate = grid.moveTowards(direction, coordinate);
            }
        }

        String obstacle = stuckedInObstacle(coordinate, lastCoordinate);

        return obstacle
                + coordinate.x()
                + ":"
                + coordinate.y()
                + ":"
                + direction.value();
    }

    private String stuckedInObstacle(Coordinate coordinate, Coordinate lastCoordinate) {
        return (lastCoordinate != null && lastCoordinate.equals(coordinate)) ?
                "O:" : "";
    }

}
