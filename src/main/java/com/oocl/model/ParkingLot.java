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

    public ParkingTicket park(Car car) throws ParkingLotIsFullException {
        for (int slotNumber = 0; slotNumber < capacity; slotNumber++) {
            if (slots[slotNumber] == null) {
                slots[slotNumber] = car;
                return new ParkingTicket(this.id, slotNumber);
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

    public int getEmptySpaceCount() {
        int countEmptySpace = 0;
        for (int slotNumber = 0; slotNumber < getCapacity(); slotNumber++) {
            if (slots[slotNumber] == null) {
                countEmptySpace++;
            }
        }
        return countEmptySpace;
    }

    public double computerAvailablePositionRate() {
        double temp = this.getEmptySpaceCount() / (double) this.getCapacity();
        return temp;
    }
}
