package advent_of_code.day_4;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));
        BingoInputParser parser = new BingoInputParser();
        System.out.println(parser.scoreInput(inputReader.readFile()));

    }
}
