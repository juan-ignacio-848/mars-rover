package com.nmkip.marsrover;

import java.util.stream.Stream;

enum Direction {

    NORTH("W", "N", "E"),
    EAST("N", "E", "S"),
    SOUTH("E", "S", "W"),
    WEST("S", "W", "N");

    private final String left;
    private final String value;
    private final String right;

    Direction(String left, String value, String right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    Direction toTheRight() {
        return toThe(right);
    }

    Direction toTheLeft() {
        return toThe(left);
    }

    private Direction toThe(String direction) {
        return Stream.of(values())
                .filter(d -> d.value.equals(direction))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    public String value() {
        return value;
    }
}
