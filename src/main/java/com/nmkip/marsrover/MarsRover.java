package com.nmkip.marsrover;

class MarsRover {

    String execute(String commands) {
        Direction direction = Direction.NORTH;

        for (char command : commands.toCharArray()) {
            if (command == 'R') {
                direction = direction.toTheRight();
            } else {
                direction = direction.toTheLeft();
            }
        }

        return "0:0:" + direction.value();
    }

}
