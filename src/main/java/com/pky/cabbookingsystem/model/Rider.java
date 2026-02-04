package com.pky.cabbookingsystem.model;

public class Rider {
    private final String id;
    private final String name;
    private Location riderLocation;

    public Rider(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Location getRiderLocation() {
        return riderLocation;
    }

    public void setRiderLocation(Location riderLocation) {
        this.riderLocation = riderLocation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
