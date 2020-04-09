package com.oocl.model;

public class CarPark {
    private static final int TOTAL_SLOT_NUM = 10;
    private Car[] slots;


    public CarPark() {
        slots = new Car[TOTAL_SLOT_NUM];
    }

    public boolean park(Car car) {
        for (int slotNumber = 0; slotNumber < TOTAL_SLOT_NUM; slotNumber++) {
            if (slots[slotNumber] == null) {
                slots[slotNumber] = car;
                return true;
            }
        }
        return false;
    }

    public Car getCarBySlotNumber(int slotNumber) {
        return slots[slotNumber];
    }
}
