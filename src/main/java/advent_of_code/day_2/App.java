package advent_of_code.day_2;

import advent_of_code.day_1.DepthIncreasesCounter;
import advent_of_code.day_1.SlidingWindowDepthIncreasesCounter;
import advent_of_code.input_handling.InputReader;
import advent_of_code.input_handling.TextFileInputReaderImpl;
import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        InputReader inputReader = new TextFileInputReaderImpl(new TextFileReader(Path.of(INPUT_TXT_PATH)));
        NavigationPlotter plotter = new NavigationPlotter();
        System.out.println(plotter.computeCommands(inputReader.processStringInputs()));
    }
}
