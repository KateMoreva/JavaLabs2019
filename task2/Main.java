package task2;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException{
        List<Animal> animals = null;
        try (FileReader fileR = new FileReader("resources/animals.txt")) {
            animals = readFromFile(fileR);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert animals != null;
        List<Animal> sortedList = animals
                .stream().sorted(Comparator.comparingInt(Animal::getFoodAmount).reversed()
                        .thenComparing(Animal::getName)).collect(Collectors.toList());

        StringBuilder result1 = new StringBuilder("Task a:\n");
        sortedList.forEach(animal -> result1.append(animal.getId()).append(" ")
                            .append(animal.getName()).append(" ")
                            .append(animal.getFoodType()).append(" ")
                            .append(animal.getFoodAmount()).append("\n"));
        writeInfo("output/resultA.txt", result1.toString());

        if (sortedList.size() >= 5) {
            StringBuilder result2 = new StringBuilder("Task b:\n");
            sortedList.stream().limit(5).forEach(animal -> result2.append(animal.getName()).append("\n"));
            writeInfo("output/resultB.txt",  String.format(" %s", result2.toString()));
        }
        if (sortedList.size() >= 3){
        StringBuilder result3 = new StringBuilder("Task c:\n");
        sortedList.stream().skip(sortedList.size() - 3).forEach(animal -> result3.append(animal.getId()).append("\n"));
        writeInfo("output/resultC.txt",  String.format(" %s", result3.toString()));
    }
    }

    private static void writeInfo(String path, String info) throws IOException{
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(info);
        }
    }

    private static List<Animal> readFromFile(InputStreamReader stReader){
        List<Animal> results = new ArrayList<>();
        Scanner scanner = new Scanner(stReader);
        while (scanner.hasNext()) {
            String[] animal = scanner.nextLine().split(" ");
            switch (animal[0]) {
                case "Omnivorous": {
                    results.add(new Omnivorous(animal[1], Integer.parseInt(animal[2]), Integer.parseInt(animal[3])));
                    break;
                }
                case "Herbivorous": {
                    results.add(new Herbivorous(animal[1], Integer.parseInt(animal[2]), Integer.parseInt(animal[3])));
                    break;
                }
                case "Carnivorous": {
                    results.add(new Carnivorous(animal[1], Integer.parseInt(animal[2]), Integer.parseInt(animal[3])));
                    break;
                }

                default: {
                    throw new IllegalArgumentException("Information has invalid data format");
                }
            }
        }
        return results;
    }
}


