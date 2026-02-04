package com.pky.cabbookingsystem;

import com.pky.cabbookingsystem.model.*;
import com.pky.cabbookingsystem.pricing.PricingStrategy;
import com.pky.cabbookingsystem.pricing.VehicleTypePricingStrategy;
import com.pky.cabbookingsystem.service.BookingService;
import com.pky.cabbookingsystem.service.CabService;
import com.pky.cabbookingsystem.service.RiderService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        RiderService riderService = new RiderService();
        CabService cabService = new CabService();
        PricingStrategy strategy = new VehicleTypePricingStrategy();

        BookingService bookingService = new BookingService(cabService, strategy);

        Rider rider = riderService.registerRider("r1", "Pky");
        Location pickup = new Location(10,10);
        rider.setRiderLocation(pickup);

        Location drop = new Location(20,20);

        cabService.registerCab("c1", "driverOne", new Location(11,11), VehicleType.AUTO);
        cabService.registerCab("c2", "driverTwo", new Location(14,11), VehicleType.SEDAN);
        cabService.registerCab("c3", "driverThree", new Location(21,11), VehicleType.BIKE);
        cabService.registerCab("c4", "driverFour", new Location(15,11), VehicleType.SUV);
        cabService.registerCab("c5", "driverFive", new Location(10,11), VehicleType.SEDAN);

        System.out.println("Fare Estimation");

        List<VehicleFareEstimate> estimates = bookingService.showAvailableVehicleTypes(pickup, drop);
        for(VehicleFareEstimate e: estimates){
            System.out.println(" -"+ e);
        }

        VehicleType selectedVehicleType = VehicleType.SEDAN;

        Booking booking = null;
        try{
            booking = bookingService.bookCab(rider, selectedVehicleType, drop);
        } catch (RuntimeException e){
            System.out.println("Booking Failed" + e.getMessage());
        }

        bookingService.startRide(booking);
        System.out.println("Ride is in Progress");
        for (int i = 1; i <=5 ; i++) {
            try{
                System.out.println("After Direction Move Left " + i + "Meters");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Reached to destination Ending Ride");
        bookingService.endRide(booking);
        System.out.println("Final Summary");
        booking.summary();
    }
}