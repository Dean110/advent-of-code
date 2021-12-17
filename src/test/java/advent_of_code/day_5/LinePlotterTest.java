package advent_of_code.day_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinePlotterTest {

    private VentMap map;
    private LinePlotter underTest;

    @BeforeEach
    void setUp() {
        map = new VentMap(10, 10);
        underTest = new LinePlotter(map);
    }

    @Test
    public void plotLines1() {
        assertOverlappedPoints(1, """
                0,1 -> 0,2
                0,0 -> 0,1
                """);
    }

    @Test
    public void plotLines2() {
        assertOverlappedPoints(2, """
                0,1 -> 0,2
                0,0 -> 0,1
                0,1 -> 0,2
                """);
    }

    @Test
    public void plotLines3() {
        assertOverlappedPoints(3, """
                0,1 -> 0,2
                0,0 -> 0,1
                0,0 -> 0,2
                """);
    }

    @Test
    public void plotLines4() {
        assertOverlappedPoints(3, """
                0,2 -> 0,1
                0,0 -> 0,1
                0,0 -> 0,2
                """);
    }

    @Test
    public void plotLines5() {
        assertOverlappedPoints(4, """
                0,2 -> 0,1
                0,0 -> 0,1
                0,0 -> 0,2
                1,0 -> 0,1
                1,0 -> 1,1
                """);
    }

    private void assertOverlappedPoints(int expected, String rawInput) {
        List<String> inputs = parseRawInput(rawInput);
        underTest.plotLines(inputs);
        assertThat(map.countOverlappedPoints()).isEqualTo(expected);
    }

    private List<String> parseRawInput(String rawInput) {
        return Arrays.stream(rawInput.split("\n")).toList();
    }
}
