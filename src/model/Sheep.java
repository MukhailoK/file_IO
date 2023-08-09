package model;

import java.util.ArrayList;
import java.util.List;

public class Sheep {
    private List<Passenger> passengers;

    public Sheep() {
        this.passengers = new ArrayList<>();
    }

    public Sheep(List<Passenger> passengers) {
        this.passengers = new ArrayList<>(passengers);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "passengers=" + passengers +
                '}';
    }


}
