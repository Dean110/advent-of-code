package advent_of_code.input_handling;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileInputReaderImpl implements InputReader {
    private final TextFileReader fileReader;

    public TextFileInputReaderImpl(TextFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Integer> processDepthInputs() {
        String input = fileReader.readFile();
        String[] lineItems = input.split("\n");
        return Arrays.stream(lineItems)
                .map(str -> Integer.parseInt(str))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> processStringInputs() {
        return Arrays.stream(fileReader.readFile()
                     .split("\n"))
                     .toList().stream()
                              .collect(Collectors.toList());
    }
}
