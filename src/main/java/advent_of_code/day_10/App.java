package advent_of_code.day_10;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.List;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));

        List<String> lineInputs = List.of(inputReader.readFile().split("\n"));

        InputValidator validator = new InputValidator();

        int total = 0;
        for (String input : lineInputs) {
            char invalidChar = validator.evaluateExpression(input, (char) 0);

            switch (invalidChar) {
                case ')':
                    total += 3;
                    break;
                case ']':
                    total += 57;
                    break;
                case '}':
                    total += 1197;
                    break;
                case '>':
                    total += 25137;
                    break;
            }


        }
        System.out.println(total);
    }
}


