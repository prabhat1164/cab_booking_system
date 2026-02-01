# 🛺 Cab Booking System (Low-Level Design)
A scalable, object-oriented, and extensible back-end system for a ride-sharing application, built with Java.

## 📖 Overview
This project is a machine coding implementation of an Uber-like Cab Booking System. It focuses on the Low-Level Design (LLD) aspects of a ride-hailing platform, simulating real-world interactions between Riders, Drivers, and the Booking Engine.
The system is designed to be modular and extensible, handling complex business logic such as Surge Pricing, OTP verification, and dynamic Driver assignment based on proximity and vehicle type.


## 🚀 Key Features
### 👤 Rider Module
1. User Registration: Seamless onboarding for riders.
2. Smart Booking: Riders can search for cabs based on vehicle type (Hatchback, Sedan, SUV).
3. Fare Estimation: Dynamic fare calculation considering distance and vehicle type before booking.
4. Security: OTP-based ride initiation to ensure the right driver picks up the right rider.

### 🚗 Driver Module
1. Driver Onboarding: Registration and vehicle linking.
2. Real-time Availability: Drivers can toggle availability status.
3. Booking Requests: "Broadcast" mechanism where nearby drivers receive booking alerts.
4. Ride Management: Drivers handle the workflow from accepting a ride to entering the OTP and ending the trip.