package com.paradigmadigital.demeterlaw;

public class PersonImpl implements Person {

    private House house;

    @Override
    public House getHouse() {
        return house;
    }

    @Override
    public void setHouse(House house) {
        this.house = house;
    }
}
