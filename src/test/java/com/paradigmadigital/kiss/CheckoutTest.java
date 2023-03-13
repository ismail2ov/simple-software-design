package com.paradigmadigital.kiss;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CheckoutTest {

    @Test
    void validateCart() {
        Checkout checkout = new Checkout();

        boolean actual = checkout.validate();

        assertThat(actual).isTrue();
    }
}