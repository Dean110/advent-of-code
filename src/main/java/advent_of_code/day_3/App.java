package advent_of_code.day_3;

import advent_of_code.input_handling.InputReader;
import advent_of_code.input_handling.TextFileInputReaderImpl;
import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.List;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        InputReader inputReader = new TextFileInputReaderImpl(new TextFileReader(Path.of(INPUT_TXT_PATH)));
        DiagnosticReader reader = new DiagnosticReader();
        List<String> diagnostics = inputReader.processStringInputs();

        System.out.print("Power Consumption: ");
        System.out.println(reader.computePowerConsumption(diagnostics));
        System.out.print("Life Generation: ");
        System.out.println(reader.computeLifeSupportRating(diagnostics));
    }
}
