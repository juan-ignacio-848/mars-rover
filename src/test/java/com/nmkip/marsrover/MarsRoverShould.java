package com.nmkip.marsrover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MarsRoverShould {

    private final static int MAX_WIDTH = 10;
    private final static int MAX_HEIGHT = 10;

    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        marsRover = new MarsRover(new Grid(MAX_WIDTH, MAX_HEIGHT));
    }

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N"
    })
    void rotate_right(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N"
    })
    void rotate_left(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "M, 0:1:N",
            "MM, 0:2:N",
            "MMM, 0:3:N"
    })
    void move_up(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "RM, 1:0:E",
            "RMM, 2:0:E"
    })
    void move_right(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "MMMMMMMMMM, 0:0:N",
            "MMMMMMMMMMMM, 0:2:N",
    })
    void wrap_around_when_it_reaches_the_end_of_the_grid_while_moving_north(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "RMMMMMMMMMM, 0:0:E",
            "RMMMMMMMMMMMMMM, 4:0:E"
    })
    void wrap_around_when_it_reaches_the_end_of_the_grid_while_moving_east(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "LM, 9:0:W",
            "LMM, 8:0:W"
    })
    void move_left(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "LLM, 0:9:S",
            "LLMM, 0:8:S",
    })
    void move_down(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }


    @ParameterizedTest
    @CsvSource({
            "MRM, 1:1:E",
            "MRMRM, 1:0:S",
            "RMLM, 1:1:N"
    })
    void move_in_zigzag(String commands, String currentPosition) {
        assertThat(marsRover.execute(commands), is(currentPosition));
    }


    @ParameterizedTest
    @CsvSource({
            "MMM, O:0:2:N",
            "RMMLMMMMMM, O:2:2:N"
    })
    void stop_at_obstacle(String commands, String currentPosition) {
        Set<Coordinate> obstacles = Stream.of(new Coordinate(0, 3),
                new Coordinate(2, 3))
                .collect(Collectors.toSet());
        Grid grid = new Grid(MAX_WIDTH, MAX_HEIGHT, obstacles);
        MarsRover marsRover = new MarsRover(grid);

        assertThat(marsRover.execute(commands), is(currentPosition));
    }
}
