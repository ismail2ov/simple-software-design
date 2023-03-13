package com.paradigmadigital.kiss;

import com.paradigmadigital.kiss.exception.DeliveryException;

public class Delivery {

    public boolean checkAddress() {
        return true;
    }

    public boolean hasCarrier() {
        return true;
    }

    void validate() {
        if (!checkAddress()) {
            throw new DeliveryException("Invalid address");
        }

        if (!hasCarrier()) {
            throw new DeliveryException("No carrier");
        }
    }
}
