package com.nmkip.marsrover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRR, 0:0:N"
    })
    void rotate_right(String commands, String currentPosition) {
        MarsRover marsRover = new MarsRover();
        assertThat(marsRover.execute(commands), is(currentPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLL, 0:0:N",
    })
    void rotate_left(String commands, String currentPosition) {
        MarsRover marsRover = new MarsRover();
        assertThat(marsRover.execute(commands), is(currentPosition));
    }


}
