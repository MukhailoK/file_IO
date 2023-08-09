package interfaces;

import model.Passenger;

import java.util.List;

public interface SheepInterface extends Iterable<Passenger> {
    void addPassenger(Passenger passenger);

    void addPassengers(List<String[]> passengers);

    double calculateTotalFares();

    double calculateAverageFareForFirstClassTravel();

    double calculateAverageFareForSecondClassTravel();

    double calculateAverageFareForThirstClassTravel();

    int totalQuantitySurvived();

    int totalQuantityDead();

    int totalQuantityOfSurvivedMen();

    int totalQuantityOfNutSurvivedMen();

    int totalQuantityOfSurvivedWomen();

    int totalQuantityOfNotSurvivedWomen();

    int totalQuantityOfSurvivedChildren();

    int totalQuantityOfNotSurvivedChildren();

}
