package ioController;

import model.Passenger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CSVTransformer {

    public CSVTransformer() {
    }


    public void printCells(List<String[]> cells) {
        cells.forEach(strings -> {
            Arrays.stream(strings).map(string -> string + "\t").forEach(System.out::print);
            System.out.println();
        });
    }

    public List<String[]> transformToListStringsArr(String fileNameCSV) {
        List<String[]> res = new ArrayList<>();
        String[] cells;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileNameCSV))) {
            String str = bufferedReader.readLine();
            cells = str.split(",");
            while (str != null) {
                cells = str.split(",");
                res.add(cells);
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Passenger> transformToListPassengers(List<String[]> cells) {
        return IntStream.range(1, cells.size()).mapToObj(i -> transformToEntity(cells.get(i))).collect(Collectors.toList());
    }

    public Passenger transformToEntity(String[] cells) {
        Passenger passenger = new Passenger();
        passenger.setId(Integer.parseInt(cells[0]));
        passenger.setSurvived(Integer.parseInt(cells[1]) == 1);
        passenger.setPassClass(Integer.parseInt(cells[2]));
        passenger.setFirstName(cells[3]);
        passenger.setLastName(cells[4]);
        passenger.setGender(cells[5]);
        if (!cells[6].equals("")) {
            passenger.setAge(Double.parseDouble(cells[6]));
        }
        passenger.setSibSp(Integer.parseInt(cells[7]));
        passenger.setParch(Integer.parseInt(cells[8]));
        passenger.setTicket(cells[9]);
        passenger.setFare(Double.parseDouble(cells[10]));
        passenger.setCabin(cells[11]);
        if (cells.length == 13) {
            passenger.setEmbarked(cells[12]);
        }
        return passenger;
    }

}
