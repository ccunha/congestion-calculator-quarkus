package com.estudo.vehicles;

public class Diplomat implements Vehicle{
    @Override
    public String getVehicleType() {
        return "Diplomat";
    }

    @Override
    public Boolean isTollFree() {
        return true;
    }
}
