package com.estudo.vehicles;

public class Emergency implements Vehicle{
    @Override
    public String getVehicleType() {
        return "Emergency";
    }

    @Override
    public Boolean isTollFree() {
        return true;
    }
}
