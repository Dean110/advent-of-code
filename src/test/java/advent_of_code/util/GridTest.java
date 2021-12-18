package advent_of_code.util;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GridTest {
    public static final String VANILLA_GRID_INPUT = """
                                                    123
                                                    456
                                                    789""";
    private static SoftAssertions softly;

    @BeforeEach
    void setUp() {
        softly = new SoftAssertions();
    }

    @Test
    @DisplayName("Grid should be generated from a String.")
    void gridShouldBeGeneratedFromAString() {
        gridCoordinateAssertion(2, 0, 3, VANILLA_GRID_INPUT);
        gridCoordinateAssertion(0, 1, 4, VANILLA_GRID_INPUT);
        softly.assertAll();
    }

    @Test
    @DisplayName("Grid should fetch values directionally from given coordinate.")
    void gridShouldFetchValuesDirectionallyFromGivenCoordinate() {
        fetchNeighboringValueAssertion(1, 1, "NW", 1);
        fetchNeighboringValueAssertion(1, 1, "N", 2);
        fetchNeighboringValueAssertion(1, 1, "NE", 3);
        fetchNeighboringValueAssertion(1, 1, "W", 4);
        fetchNeighboringValueAssertion(1, 1, "E", 6);
        fetchNeighboringValueAssertion(1, 1, "SW", 7);
        fetchNeighboringValueAssertion(1, 1, "S", 8);
        fetchNeighboringValueAssertion(1, 1, "SE", 9);
        softly.assertAll();
    }

    @Test
    @DisplayName("Grid should return Integer.MIN_VALUE if a direction is given that is invalid.")
    void gridShouldReturnIntegerMinValueIfADirectionIsGivenThatIsInvalid() {
        assertAll(
                () -> fetchNeighboringValueExceptionAssertion(0, 0, "NW", Integer.MIN_VALUE),
                () -> fetchNeighboringValueExceptionAssertion(0, 0, "FR", Integer.MIN_VALUE)
        );
    }

    private void fetchNeighboringValueAssertion(int x, int y, String direction, int expected) {
        Grid underTest = new Grid(VANILLA_GRID_INPUT);
        int result = underTest.fetchNeighboringValue(x, y, direction);
        softly.assertThat(result).isEqualTo(expected);
    }

    private void fetchNeighboringValueExceptionAssertion(int x, int y, String direction, int expected) {
        Grid underTest = new Grid(VANILLA_GRID_INPUT);
        assertThrows(RuntimeException.class, () -> underTest.fetchNeighboringValue(x, y, direction));
    }

    private void gridCoordinateAssertion(int x, int y, int expected, String gridData) {
        Grid underTest = new Grid(gridData);
        int result = underTest.getValueAtCoordinate(x, y);
        softly.assertThat(result)
              .isEqualTo(expected);
    }
}