package com.pky.cabbookingsystem.service;

import com.pky.cabbookingsystem.model.*;
import com.pky.cabbookingsystem.pricing.PricingStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final CabService cabService;
    private final PricingStrategy pricingStrategy;

    public BookingService(CabService cabService, PricingStrategy pricingStrategy) {
        this.cabService = cabService;
        this.pricingStrategy = pricingStrategy;
    }

    public List<VehicleFareEstimate> showAvailableVehicleTypes(Location from, Location to){
        List<VehicleFareEstimate> estimatesList = new ArrayList<>();
        for (VehicleType type: VehicleType.values()){
            double fare = pricingStrategy.calculateFare(from, to, type);
            double roundedFare = BigDecimal.valueOf(fare)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();
            estimatesList.add(new VehicleFareEstimate(type, roundedFare));
        }
        return estimatesList;
    }

    public Booking bookCab(Rider rider, VehicleType vehicleType, Location dropLocation){
        Cab cab = cabService.findNearestAvailableCab(rider.getRiderLocation(), vehicleType);
        if(cab==null) throw new RuntimeException("No available Cabs for the "+ vehicleType);
        cab.assignToRide();
        double fare = pricingStrategy.calculateFare(rider.getRiderLocation(), dropLocation, cab.getVehicleType());
        Booking booking = new Booking(rider, cab, rider.getRiderLocation(), dropLocation, fare);
        booking.setStatus(BookingStatus.CREATED);
        return booking;
    }

    public void startRide(Booking booking){
        booking.setStatus(BookingStatus.STARTED);
        booking.setRideStartTime(LocalDateTime.now());
        System.out.println("Ride Started");
    }

    public void endRide(Booking booking){
        booking.setStatus(BookingStatus.ENDED);
        booking.setRideEndTime(LocalDateTime.now());

        double finalFare = pricingStrategy.calculateFare(booking.getPickup(), booking.getDrop(), booking.getCab().getVehicleType());
        booking.setRideFare(finalFare);
        System.out.println("Ride Ended");
    }
}
