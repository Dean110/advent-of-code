package advent_of_code.day_8;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));

        List<String> lineInputs = List.of(inputReader.readFile().split("\n"));

        int total = 0;
        for (String input : lineInputs) {
            String[] inputParts = input.split(Pattern.quote(" | "));
            String cipher = inputParts[0];
            String encodedOutput = inputParts[1];
            SevenSegmentDigitParser parser = new SevenSegmentDigitParser(cipher);
            String digitOutput = Arrays.stream(encodedOutput.split(" "))
                    .map(pattern -> parser.parse(pattern))
                    .collect(Collectors.joining());
            total += Integer.parseInt(digitOutput);
        }
        System.out.println(total);
    }
}


