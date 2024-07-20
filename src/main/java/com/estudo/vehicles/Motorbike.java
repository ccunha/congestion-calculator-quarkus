package com.estudo.vehicles;

public class Motorbike implements Vehicle {
    @Override
    public String getVehicleType() {
        return "Motorbike";
    }

    @Override
    public Boolean isTollFree() {
        return false;
    }
}
