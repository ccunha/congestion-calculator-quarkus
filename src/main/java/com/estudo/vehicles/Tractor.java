package com.estudo.vehicles;

public class Tractor implements Vehicle{
    @Override
    public String getVehicleType() {
        return "Tractor";
    }

    @Override
    public Boolean isTollFree() {
        return true;
    }
}
