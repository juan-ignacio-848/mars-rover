package com.nmkip.marsrover;

class MarsRover {

    String execute(String commands) {
        String direction = "N";

        for (char command : commands.toCharArray()) {
            direction = rotateRight(direction);
        }

        return "0:0:" + direction;
    }

    private String rotateRight(String direction) {
        if (direction.equals("N"))
            return "E";
        else if (direction.equals("E"))
            return "S";
        else if (direction.equals("S"))
            return "W";
        else
            return "N";
    }
}
