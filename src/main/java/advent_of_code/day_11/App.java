package advent_of_code.day_11;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));

        String gridInputs = inputReader.readFile();
        System.out.println(gridInputs);
        OctopiTracker tracker = new OctopiTracker(gridInputs);

        for (int i = 0; i < 10000; i++) {
            try {
                tracker.tick();
            } catch (Exception e) {
                System.out.println(i+1 - 10);
                break;
            }

        }
        System.out.println(tracker.getFlashCount());
    }
}
