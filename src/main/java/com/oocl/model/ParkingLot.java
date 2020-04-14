package com.oocl.model;

import com.oocl.util.customException.ParkingLotIsFullException;

public class ParkingLot {
    private int id;
    private int capacity;
    private int remainingSpaceCount;
    private Car[] slots;


    public ParkingLot(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.remainingSpaceCount = capacity;
        slots = new Car[capacity];
    }

    public ParkingTicket park(Car car) throws ParkingLotIsFullException {
        for (int slotNumber = 0; slotNumber < capacity; slotNumber++) {
            if (slots[slotNumber] == null) {
                slots[slotNumber] = car;
                this.remainingSpaceCount--;
                return new ParkingTicket(this.id, slotNumber);
            }
        }
        throw new ParkingLotIsFullException();
    }

    public Car returnCar(int slotNumber) {
        Car car = slots[slotNumber];
        slots[slotNumber] = null;
        this.remainingSpaceCount++;
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
        return remainingSpaceCount <= 0;
    }

    public int getEmptySpaceCount() {
        return remainingSpaceCount;
    }

    public double computerAvailablePositionRate() {
        return this.getEmptySpaceCount() / (double) this.getCapacity();
    }
}
