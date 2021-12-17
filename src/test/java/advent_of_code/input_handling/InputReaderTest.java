package advent_of_code.input_handling;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InputReaderTest {
    public static final String END_OF_LINE = System.getProperty("line.separator");
    private InputReader underTest;
    private TextFileReader testFileReader;

    @BeforeEach
    void setUp() {
        testFileReader = mock(TextFileReader.class);
        underTest = new TextFileInputReaderImpl(testFileReader);
    }

    @Test
    public void whenInputContainsFourIntegers_ExpectIntegersGivenAndPreciseOrder() {
        when(testFileReader.readFile()).thenReturn("1\n2\n3\n4");
        List<Integer> result = underTest.processDepthInputs();
        assertThat(result).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void whenInputContainsAnootherFourIntegers_ExpectIntegersGivenAndPreciseOrder() {
        when(testFileReader.readFile()).thenReturn("1\n3\n2\n4");
        List<Integer> result = underTest.processDepthInputs();
        assertThat(result).containsExactly(1, 3, 2, 4);
    }

    @Test
    public void processStringInputs() {
        when(testFileReader.readFile()).thenReturn("forward 1\ndown 3\nup 2");
        List<String> result = underTest.processStringInputs();
        assertThat(result).containsExactly("forward 1", "down 3", "up 2");
    }
}
