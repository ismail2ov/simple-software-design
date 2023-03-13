package com.paradigmadigital.kiss;

import com.paradigmadigital.kiss.exception.CartException;

public class Cart {

    public static final int MIN_PURCHASE_AMOUNT = 30;
    public static final int MAX_PURCHASE_AMOUNT = 10000;

    public int getNumProducts() {
        return 1;
    }

    public float getTotal() {
        return 30;
    }

    public boolean checkStock() {
        return true;
    }

    public void validate() {
        if (getNumProducts() <= 0) {
            throw new CartException("The cart is empty");
        }

        if (getTotal() < MIN_PURCHASE_AMOUNT) {
            throw new CartException("Does not reach the minimum required for the cart");
        }

        if (getTotal() >= MAX_PURCHASE_AMOUNT) {
            throw new CartException("You have exceeded the maximum total allowed for a purchase");
        }

        if (!checkStock()) {
            throw new CartException("No hay stock");
        }
    }
}
