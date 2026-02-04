package com.pky.cabbookingsystem.model;

import java.time.LocalDateTime;

public class Booking {
    private final Rider rider;
    private final Cab cab;
    private Location pickup;
    private Location drop;
    private final LocalDateTime bookingTime;
    private LocalDateTime rideStartTime;
    private LocalDateTime rideEndTime;
    private double rideFare;
    private BookingStatus status;

    public Booking(Rider rider, Cab cab, Location pickup, Location drop, double rideFare) {
        this.rider = rider;
        this.cab = cab;
        this.pickup = pickup;
        this.drop = drop;
        this.rideFare = rideFare;
        this.bookingTime = LocalDateTime.now();
    }

    public Cab getCab() {
        return cab;
    }

    public Location getDrop() {
        return drop;
    }

    public void setDrop(Location drop) {
        this.drop = drop;
    }

    public Location getPickup() {
        return pickup;
    }

    public void setPickup(Location pickup) {
        this.pickup = pickup;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    public LocalDateTime getRideEndTime() {
        return rideEndTime;
    }

    public void setRideEndTime(LocalDateTime rideEndTime) {
        this.rideEndTime = rideEndTime;
    }

    public double getRideFare() {
        return rideFare;
    }

    public void setRideFare(double rideFare) {
        this.rideFare = rideFare;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void summary(){
        System.out.println("Booking Summary");
        System.out.println("Rider: "+ rider.getName());
        System.out.println("Driver: "+ cab.getDriverName());
        System.out.println("Pickup :"+ pickup + " Drop :"+ drop);
        System.out.println("Vehicle :"+ cab.getVehicleType());
        System.out.println("Fare: "+ rideFare);
        System.out.println("Time: "+ bookingTime);
    }
}
