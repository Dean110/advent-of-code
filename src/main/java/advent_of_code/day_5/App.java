package advent_of_code.day_5;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.Arrays;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));
        VentMap ventMap = new VentMap(1000, 1000);
        LinePlotter plotter = new LinePlotter(ventMap);
        plotter.plotLines(Arrays.stream(inputReader.readFile()
                                                   .split("\n"))
                                .toList());
        System.out.println(ventMap.countOverlappedPoints());

    }
}
