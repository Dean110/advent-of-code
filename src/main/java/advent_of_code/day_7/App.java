package advent_of_code.day_7;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));
        List<Integer> crabPositions = Arrays.stream(inputReader.readFile()
                                                               .split(","))
                                            .map(Integer::parseInt)
                                            .toList();
        int maxPosition = crabPositions.stream()
                                       .mapToInt(v -> v)
                                       .max()
                                       .getAsInt();

        int[] modes = new int[maxPosition + 1];
        crabPositions.stream()
                     .forEach(p -> modes[p]++);
        int modiest = 0;
        int mode = 0;
        for (int i = 0; i < modes.length; i++) {
            if (modes[i] > 0 && modes[i] >= modiest) {
                modiest = modes[i];
                mode = modes[i];
            }
        }

        int avg = (int) Math.round(crabPositions.stream()
                                                .mapToInt(v -> v)
                                                .average()
                                                .getAsDouble());

        //for each destination
        for (int dest = 0; dest <= maxPosition; dest++) {
            //how much gas does it take to get to dest?
            int gasUsed = 0;

            //for each crab
            for (int i = 0; i < crabPositions.size(); i++) {
                //how much gas is used?
                int startingDestination = crabPositions.get(i);
                int crabGasUsed = 0;
                int distanceToTravel = Math.abs(startingDestination - dest);

                while (distanceToTravel > 0) {
                    crabGasUsed += distanceToTravel;
                    distanceToTravel--;
                }
                gasUsed += crabGasUsed;
            }

            System.out.println(String.format("Gas used going to position %d: %d", dest, gasUsed));
        }

        System.out.println(String.format("Average: %f", crabPositions.stream()
                                                                     .mapToInt(v -> v)
                                                                     .average()
                                                                     .getAsDouble()));
    }
}
