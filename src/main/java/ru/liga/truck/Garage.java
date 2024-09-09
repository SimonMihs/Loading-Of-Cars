package ru.liga.truck;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Truck> trucks;

    public Garage() {
        trucks = new ArrayList<>();
    }

    public List<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Truck> trucksNew) {
        trucks = trucksNew;
    }

    public void removeTruc(int index) {
        trucks.remove(index);
    }

    public int size() {
        return trucks.size();
    }

    public Truck getTruck() {
        return trucks.getLast();
    }

    public void addTruck(Truck truck) {
        trucks.add(truck);
    }

}
