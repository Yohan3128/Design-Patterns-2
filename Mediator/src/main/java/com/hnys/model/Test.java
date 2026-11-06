package com.hnys.model;

interface AirTrafficControl {
    public void requestTakeoff(Flight flight);
    public void requestLanding(Flight flight);
    public void notifyFlight(String message, Flight flight);
}

class AirportControlTower implements AirTrafficControl {

    @Override
    public void requestTakeoff(Flight flight) {
        System.out.println("Flight " + flight.getNumber() + " is requesting takeoff.");
        // Logic to handle takeoff request
    }

    @Override
    public void requestLanding(Flight flight) {
        System.out.println("Flight " + flight.getNumber() + " is requesting landing.");
        // Logic to handle landing request
    }

    @Override
    public void notifyFlight(String message, Flight flight) {
        System.out.println("Notifying flight " + flight.getNumber() + ": " + message);
        flight.receiveMessage(message);
    }
}

abstract class Flight {

    private String number;

    public String getNumber() {
        return number;
    }

    public void requestTakeoff() {
    }

    public void requestLanding() {
    }

    public abstract void receiveMessage(String message);

}

public class Test {
    public static void main(String[] args) {

    }
}
