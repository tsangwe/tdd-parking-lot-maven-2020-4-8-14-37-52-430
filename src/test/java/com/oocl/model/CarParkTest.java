package com.oocl.model;

import org.junit.Assert;
import org.junit.Test;


public class CarParkTest {

    @Test
    public void should_return_true_when_car_parked_to_slot() {
        CarPark carPark = new CarPark();
        Car car = new Car();
        if (carPark.park(car)) {
            Assert.assertEquals(true, carPark.getCarBySlotNumber(0) == car);
        }
    }
}