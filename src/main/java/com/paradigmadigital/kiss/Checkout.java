package com.paradigmadigital.kiss;

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
        cart.validate();
        delivery.validate();
        payment.validate();

        return true;
    }

}
