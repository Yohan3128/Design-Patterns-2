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
        notifyFlight("Takeoff approved. You may proceed.", flight);
    }

    @Override
    public void requestLanding(Flight flight) {
        System.out.println("Flight " + flight.getNumber() + " is requesting landing.");
        notifyFlight("Landing approved. You may proceed.", flight);
    }

    @Override
    public void notifyFlight(String message, Flight flight) {
        System.out.println("Notifying flight " + flight.getNumber() + ": " + message);
        flight.receiveMessage(message);
    }
}

abstract class Flight {

    private AirTrafficControl airTrafficControl;
    private String number;

    public Flight(AirTrafficControl airTrafficControl, String number) {
        this.airTrafficControl = airTrafficControl;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void requestTakeoff() {
        airTrafficControl.requestTakeoff(this);
    }

    public void requestLanding() {
        airTrafficControl.requestLanding(this);
    }

    public abstract void receiveMessage(String message);

}

class CommercialFlight extends Flight {

    public CommercialFlight(AirTrafficControl airTrafficControl, String number) {
        super(airTrafficControl, number);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Commercial flight " + getNumber() + " received message: " + message);
    }
}

class PrivateFlight extends Flight {

    public PrivateFlight(AirTrafficControl airTrafficControl, String number) {
        super(airTrafficControl, number);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Private flight " + getNumber() + " received message: " + message);
    }
}


public class Test {
    public static void main(String[] args) {

        AirportControlTower airportControlTower = new AirportControlTower();

        Flight commercialFlight = new CommercialFlight(airportControlTower, "CF123");
        Flight privateFlight = new PrivateFlight(airportControlTower, "PF456");
        Flight privateFlight2 = new PrivateFlight(airportControlTower, "PF789");

        commercialFlight.requestTakeoff();
        System.out.println();
        privateFlight.requestLanding();
        System.out.println();
        privateFlight2.requestLanding();

    }
}
