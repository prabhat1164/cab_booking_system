package com.pky.cabbookingsystem.pricing;

import com.pky.cabbookingsystem.model.Location;
import com.pky.cabbookingsystem.model.VehicleType;

public interface PricingStrategy {
    double calculateFare(Location from, Location to, VehicleType vehicleType);

}
