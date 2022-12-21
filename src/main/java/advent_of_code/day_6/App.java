package advent_of_code.day_6;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.Arrays;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    //Match 354564
    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));
        long[] fishBuckets = new long[9];

        Arrays.stream(inputReader.readFile()
                                 .split(","))
              .forEach(str -> fishBuckets[Integer.parseInt(str)]++);

        int daysLeft = 256;

        while (daysLeft > 0) {
            long fishToSpawn = fishBuckets[0];
            for (int i = 0; i < 8; i++) {
                fishBuckets[i] = fishBuckets[i + 1];
            }
            fishBuckets[6] += fishToSpawn;
            fishBuckets[8] = fishToSpawn;

            daysLeft--;
        }
        System.out.println(Arrays.stream(fishBuckets)
                                 .sum());
    }
}
