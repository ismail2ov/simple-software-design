package com.paradigmadigital.kiss;

import com.paradigmadigital.kiss.exception.CartException;
import com.paradigmadigital.kiss.exception.DeliveryException;
import com.paradigmadigital.kiss.exception.PaymentException;

public class Checkout {

    Cart cart;
    Delivery delivery;
    Payment payment;

    public Checkout() {
        cart = new Cart();
        delivery = new Delivery();
        payment = new Payment();
    }

    public boolean validateCart() {

        if (cart.getNumProducts() > 0) {

            if (cart.getTotal() >= Cart.MIN_PURCHASE_AMOUNT) {

                if (cart.getTotal() < Cart.MAX_PURCHASE_AMOUNT) {

                    if (cart.checkStock()) {

                        if (delivery.checkAddress()) {

                            if (delivery.hasCarrier()) {

                                if (payment.hasPaymentMethods()) {

                                    if (payment.isCompulsiveBuyer()) {

                                        return true;

                                    } else {
                                        throw new PaymentException("Are you a compulsive buyer signed");
                                    }
                                } else {
                                    throw new PaymentException("No payment methods");
                                }
                            } else {
                                throw new DeliveryException("No carrier");
                            }
                        } else {
                            throw new DeliveryException("Invalid address");
                        }
                    } else {
                        throw new CartException("No hay stock");
                    }
                } else {
                    throw new CartException("You have exceeded the maximum total allowed for a purchase");
                }
            } else {
                throw new CartException("Does not reach the minimum required for the cart");
            }
        } else {
            throw new CartException("The cart is empty");
        }
    }
}
