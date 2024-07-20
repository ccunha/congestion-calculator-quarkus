package com.estudo.vehicles;

public class Foreign implements Vehicle{
    @Override
    public String getVehicleType() {
        return "Foreign";
    }

    @Override
    public Boolean isTollFree() {
        return true;
    }
}
