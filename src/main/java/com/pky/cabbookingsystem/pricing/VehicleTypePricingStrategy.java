package com.pky.cabbookingsystem.pricing;

import com.pky.cabbookingsystem.model.Location;
import com.pky.cabbookingsystem.model.VehicleType;

public class VehicleTypePricingStrategy implements  PricingStrategy{

    @Override
    public double calculateFare(Location from, Location to, VehicleType vehicleType) {
        double baseRatePerKm;
        switch (vehicleType){
            case BIKE -> baseRatePerKm =2.0;
            case AUTO -> baseRatePerKm =4.0;
            case SEDAN -> baseRatePerKm =8.0;
            case SUV -> baseRatePerKm =10.0;
            default -> throw new IllegalStateException("Unexpected value: " + vehicleType);
        }
        return baseRatePerKm * (from.calculateDistance(to));
    }
}
