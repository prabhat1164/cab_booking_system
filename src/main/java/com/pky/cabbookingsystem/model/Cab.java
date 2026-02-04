package com.pky.cabbookingsystem.model;

public class Cab {
    private final String id;
    private final String driverName;
    private Location cabLocation;
    private boolean isAvailable;
    private final VehicleType vehicleType;

    public Cab(String id, String driverName, VehicleType vehicleType, Location cabLocation, boolean isAvailable) {
        this.id = id;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
        this.cabLocation = cabLocation;
        this.isAvailable = true;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Location getCabLocation() {
        return cabLocation;
    }

    public void setCabLocation(Location cabLocation) {
        this.cabLocation = cabLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }
}
