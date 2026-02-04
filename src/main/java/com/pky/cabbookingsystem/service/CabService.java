package com.pky.cabbookingsystem.service;

import com.pky.cabbookingsystem.model.Cab;
import com.pky.cabbookingsystem.model.Location;
import com.pky.cabbookingsystem.model.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CabService {
    private final List<Cab> cabs = new ArrayList<>();
    public void registerCab(String id, String driverName, Location cabLocation, VehicleType vehicleType){
        cabs.add(new Cab(id, driverName, vehicleType, cabLocation));
    }

    public Cab findNearestAvailableCab(Location riderLocation, VehicleType vehicleType){
        double minDistance = Double.MAX_VALUE;
        Cab nearestCab = null;
        for (Cab cab: cabs){
            if(cab.isAvailable() && cab.getVehicleType() == vehicleType){
                double distance = cab.getCabLocation().calculateDistance(riderLocation);
                if(distance < minDistance){
                    minDistance = distance;
                    nearestCab = cab;
                }
            }
        }
        return nearestCab;
    }
}
