package day_1.input_handling;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextFileInputReaderImpl implements InputReader {
    private TextFileReader fileReader;

    public TextFileInputReaderImpl(TextFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Integer> processDepthsInput() {
        String input = fileReader.readFile();
        String[] lineItems = input.split("\n");
        return Arrays.stream(lineItems)
                .map(str -> Integer.parseInt(str))
                .collect(Collectors.toList());
    }
}
