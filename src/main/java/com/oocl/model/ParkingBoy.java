package com.oocl.model;

public class ParkingBoy {

    private CarPark carPark;

    public ParkingBoy() {
        this.carPark = new CarPark();
    }

    public ParkingTicket park(Car car) {
        carPark.park(car);
        return new ParkingTicket();
    }

}
