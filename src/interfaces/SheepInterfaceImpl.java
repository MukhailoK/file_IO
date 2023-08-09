package interfaces;

import ioController.CSVTransformer;
import model.Passenger;
import model.Sheep;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SheepInterfaceImpl implements SheepInterface {
    Sheep sheep;

    public SheepInterfaceImpl() {
        this.sheep = new Sheep();
    }

    public SheepInterfaceImpl(List<Passenger> passengers) {
        sheep = new Sheep(passengers);
    }

    public void addPassenger(Passenger passenger) {
        sheep.add(passenger);
    }

    public void addPassengers(List<String[]> passengers) {
        IntStream.range(1, passengers.size())
                .forEachOrdered(passenger -> addPassenger(new CSVTransformer()
                        .transformToEntity(passengers.get(passenger))));
    }

    public double calculateTotalFares() {
        return sheep.getPassengers().stream().mapToDouble(Passenger::getFare).sum();
    }

    public double calculateAverageFareForFirstClassTravel() {
        return calculateByPredicate(passenger -> passenger.getPassClass() == 1);
    }

    public double calculateAverageFareForSecondClassTravel() {
        return calculateByPredicate(passenger -> passenger.getPassClass() == 2);
    }

    public double calculateAverageFareForThirstClassTravel() {
        return calculateByPredicate(passenger -> passenger.getPassClass() == 3);
    }

    private double calculateByPredicate(Predicate<Passenger> predicate) {
        int count = 0;
        double totalFares = 0;

        for (Passenger passenger : sheep.getPassengers()) {
            if (predicate.test(passenger)) {
                count++;
                totalFares += passenger.getFare();
            }
        }
        return totalFares / count;
    }


    public int totalQuantitySurvived() {
        return getQuantityPassengersByPredicate(Passenger::isSurvived);
    }

    public int totalQuantityDead() {
        return getQuantityPassengersByPredicate(passenger -> !passenger.isSurvived());
    }

    public int totalQuantityOfSurvivedMen() {
        return getQuantityPassengersByPredicate(passenger -> passenger.getAge() >= 18 && passenger.getGender().equals("male") && passenger.isSurvived());
    }

    public int totalQuantityOfNutSurvivedMen() {
        return getQuantityPassengersByPredicate(passenger -> passenger.getAge() >= 18 && passenger.getGender().equals("male") && !passenger.isSurvived());
    }

    public int totalQuantityOfSurvivedWomen() {
        return getQuantityPassengersByPredicate(passenger -> passenger.getAge() >= 18 && passenger.getGender().equals("female") && passenger.isSurvived());
    }

    public int totalQuantityOfNotSurvivedWomen() {
        return getQuantityPassengersByPredicate(passenger -> passenger.getAge() >= 18 && passenger.getGender().equals("female") && !passenger.isSurvived());
    }

    public int totalQuantityOfSurvivedChildren() {
        return getQuantityPassengersByPredicate(passenger -> passenger.getAge() != 0 && passenger.getAge() < 18 && passenger.isSurvived());
    }

    public int totalQuantityOfNotSurvivedChildren() {
        return getQuantityPassengersByPredicate(passenger -> passenger.getAge() != 0 && passenger.getAge() < 18 && !passenger.isSurvived());
    }


    private int getQuantityPassengersByPredicate(Predicate<Passenger> predicate) {
        return (int) sheep.getPassengers().stream().filter(predicate).count();


    }

    @Override
    public Iterator<Passenger> iterator() {
        return sheep.getPassengers().iterator();
    }
}
