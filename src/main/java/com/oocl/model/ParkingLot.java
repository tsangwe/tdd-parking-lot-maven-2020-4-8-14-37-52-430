package com.oocl.model;

public class ParkingLot {
    private static final int TOTAL_SLOT_NUM = 10;
    private Car[] slots;


    public ParkingLot() {
        slots = new Car[TOTAL_SLOT_NUM];
    }

    public Integer park(Car car) {
        for (int slotNumber = 0; slotNumber < TOTAL_SLOT_NUM; slotNumber++) {
            if (slots[slotNumber] == null) {
                slots[slotNumber] = car;
                return slotNumber;
            }
        }
        return null;
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
