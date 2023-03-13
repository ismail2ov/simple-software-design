package com.paradigmadigital.kiss;

import com.paradigmadigital.kiss.exception.PaymentException;

public class Payment {

    public boolean hasPaymentMethods() {
        return true;
    }

    public boolean isCompulsiveBuyer() {
        return true;
    }

    public void validate() {
        if (!hasPaymentMethods()) {
            throw new PaymentException("No payment methods");
        }

        if (!isCompulsiveBuyer()) {
            throw new PaymentException("Are you a compulsive buyer signed");
        }
    }
}
