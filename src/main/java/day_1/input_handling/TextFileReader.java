package day_1.input_handling;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextFileReader {
    private Path filePath;

    public TextFileReader(Path filePath) {

        this.filePath = filePath;
    }

    public String readFile() {
        try {

            String readString = Files.readString(filePath);
            return readString;
        } catch (IOException e) {
            throw new RuntimeException("File could not be read.", e);
        }
    }
}
