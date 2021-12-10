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

    @Test
    public void sampleTest() {
        assertOverlappedPoints(5, """
                0,9 -> 5,9
                8,0 -> 0,8
                9,4 -> 3,4
                2,2 -> 2,1
                7,0 -> 7,4
                6,4 -> 2,0
                0,9 -> 2,9
                3,4 -> 1,4
                0,0 -> 8,8
                5,5 -> 8,2
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
