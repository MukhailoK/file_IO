import interfaces.SheepInterface;
import interfaces.SheepInterfaceImpl;
import ioController.CSVTransformer;
import model.Passenger;

import java.util.List;


public class Main {
    private static final String FILE_NAME = "train.csv";

    public static void main(String[] args) {

        CSVTransformer csvTransformer = new CSVTransformer();

        List<String[]> passengers = csvTransformer.transformToListStringsArr(FILE_NAME);

        SheepInterface sheep = new SheepInterfaceImpl(csvTransformer.transformToListPassengers(passengers));

        for (Passenger passenger : sheep) {
            System.out.println(passenger);
        }

        System.out.println("Total fares = " + sheep.calculateTotalFares());
        System.out.println("Average fare for 1 class of travel = " + sheep.calculateAverageFareForFirstClassTravel());
        System.out.println("Average fare for 2 class of travel = " + sheep.calculateAverageFareForSecondClassTravel());
        System.out.println("Average fare for 3 class of travel = " + sheep.calculateAverageFareForThirstClassTravel());
        System.out.println("Survived: " + sheep.totalQuantitySurvived());
        System.out.println("Not survived: " + sheep.totalQuantityDead());
        System.out.println("Survived men: " + sheep.totalQuantityOfSurvivedMen());
        System.out.println("Not survived men: " + sheep.totalQuantityOfNutSurvivedMen());
        System.out.println("Survived women: " + sheep.totalQuantityOfSurvivedWomen());
        System.out.println("Not survived women: " + sheep.totalQuantityOfNotSurvivedWomen());
        System.out.println("Survived children: " + sheep.totalQuantityOfSurvivedChildren());
        System.out.println("Not survived children: " + sheep.totalQuantityOfNotSurvivedChildren());
        System.out.println("Survived from 1 class: " + sheep.totalSurvivedFromFirstClass());
        System.out.println("Not survived from 1 class: " + sheep.totalNotSurvivedFromFirstClass());

//        Survived from 3 class: 119
//        Not survived from 3 class: 372
    }
}
