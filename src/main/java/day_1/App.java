package day_1;

import day_1.input_handling.InputReader;
import day_1.input_handling.TextFileInputReaderImpl;
import day_1.input_handling.TextFileReader;

import java.nio.file.Path;

public class App {
    public static final String DEPTHS_INPUT_TXT_PATH = "src/main/resources/depth_inputs.txt";

    public static void main(String[] args) {
        InputReader inputReader = new TextFileInputReaderImpl(new TextFileReader(Path.of(DEPTHS_INPUT_TXT_PATH)));
        DepthIncreasesCounter counter = new DepthIncreasesCounter();
        System.out.println(counter.calculate(inputReader.processDepthsInput()));
    }
}
