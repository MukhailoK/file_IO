import interfaces.SheepInterface;
import interfaces.SheepInterfaceImpl;
import ioController.CSVTransformer;

import java.util.List;


public class Main {
    private static final String FILE_NAME = "train.csv";

    public static void main(String[] args) {

        CSVTransformer csvTransformer = new CSVTransformer();

        List<String[]> passengers = csvTransformer.transformToListStringsArr(FILE_NAME);

        SheepInterface sheep = new SheepInterfaceImpl(csvTransformer.transformToListPassengers(passengers));

//        csvTransformer.printCells(passengers);
        System.out.println(sheep);
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

    }
}
