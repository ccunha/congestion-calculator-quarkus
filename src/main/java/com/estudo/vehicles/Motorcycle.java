package com.estudo.vehicles;

public class Motorcycle implements Vehicle{
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }

    @Override
    public Boolean isTollFree() {
        return true;
    }
}
