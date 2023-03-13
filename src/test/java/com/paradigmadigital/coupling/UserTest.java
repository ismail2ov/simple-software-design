package com.paradigmadigital.coupling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testSetUserName() {
        user.setName("Luke Skywalker");

        String actual = user.getName();

        assertThat(actual).isEqualTo("Luke Skywalker");
    }

    @Test
    void whenNameIsNullThenThrowException() {

        Throwable thrown = catchThrowable(() -> user.setName(null));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
            .hasMessageStartingWith("Argument for @NotNull parameter 'name'");
    }
}