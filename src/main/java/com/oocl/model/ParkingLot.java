package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

public class ParkingLot {
    private int id;
    private int capacity;
    private Car[] slots;


    public ParkingLot(int id, int capacity) {
        this.id = id;
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

    public Car returnCar(int slotNumber) {
        Car car = slots[slotNumber];
        slots[slotNumber] = null;
        return car;
    }

    public Car getCarBySlotNumber(int slotNumber) {
        return slots[slotNumber];
    }

    public Car[] getSlots() {
        return this.slots;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isFull() {
        for (int slotNumber = 0; slotNumber < getCapacity(); slotNumber++) {
            if (slots[slotNumber] == null) {
                return false;
            }
        }
        return true;
    }

    public int getEmptySpace() {
        int countEmptySpace = 0;
        for (int slotNumber = 0; slotNumber < getCapacity(); slotNumber++) {
            if (slots[slotNumber] == null) {
                countEmptySpace++;
            }
        }
        return countEmptySpace;
    }
}
