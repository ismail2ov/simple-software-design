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

    public boolean validate() {
        validateCart();
        validateDelivery();
        validatePayment();

        return true;
    }

    private void validatePayment() {
        if (!payment.hasPaymentMethods()) {
            throw new PaymentException("No payment methods");
        }

        if (!payment.isCompulsiveBuyer()) {
            throw new PaymentException("Are you a compulsive buyer signed");
        }
    }

    private void validateDelivery() {
        if (!delivery.checkAddress()) {
            throw new DeliveryException("Invalid address");
        }

        if (!delivery.hasCarrier()) {
            throw new DeliveryException("No carrier");
        }
    }

    private void validateCart() {
        if (cart.getNumProducts() <= 0) {
            throw new CartException("The cart is empty");
        }

        if (cart.getTotal() < Cart.MIN_PURCHASE_AMOUNT) {
            throw new CartException("Does not reach the minimum required for the cart");
        }

        if (cart.getTotal() >= Cart.MAX_PURCHASE_AMOUNT) {
            throw new CartException("You have exceeded the maximum total allowed for a purchase");
        }

        if (!cart.checkStock()) {
            throw new CartException("No hay stock");
        }
    }
}
