package com.estudo.vehicles;

public class Car implements Vehicle {

    public String getVehicleType() {
        return "Car";
    }

    @Override
    public Boolean isTollFree() {
        return false;
    }
}