package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

public class ParkingLot {
    private int capacity;
    private Car[] slots;


    public ParkingLot(int capacity) {
        this.capacity = capacity;
        slots = new Car[capacity];
    }

    public Integer park(Car car) throws ParkingLotIsFullException {
        for (int slotNumber = 0; slotNumber < capacity; slotNumber++) {
            if (slots[slotNumber] == null) {
                slots[slotNumber] = car;
                return slotNumber;
            }
        }
        throw new ParkingLotIsFullException();
    }

    public Car getCarBySlotNumber(int slotNumber) {
        return slots[slotNumber];
    }

    public Car[] getSlots() {
        return this.slots;
    }

    public Car returnCar(int slotNumber) {
        Car car = slots[slotNumber];
        if (car == null) {
            System.out.println("Invalid ticket");
        }
        slots[slotNumber] = null;
        return car;
    }
}
