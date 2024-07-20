package com.estudo.vehicles;

public class Military implements Vehicle{
    @Override
    public String getVehicleType() {
        return "Military";
    }

    @Override
    public Boolean isTollFree() {
        return true;
    }
}
