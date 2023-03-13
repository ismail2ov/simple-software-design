package com.paradigmadigital.coupling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void testSetUserName() {
        user.name = "Luke Skywalker";

        String actual = user.name;

        assertThat(actual).isEqualTo("Luke Skywalker");
    }

    @Disabled
    @Test
    void whenNameIsNullThenThrowException() {

        Throwable thrown = catchThrowable(() -> user.name = null);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
            .hasMessageStartingWith("Argument for @NotNull parameter 'name'");
    }
}