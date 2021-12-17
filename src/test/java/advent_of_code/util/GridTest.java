package advent_of_code.util;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.*;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.setDescriptionConsumer;

class GridTest {
    static SoftAssertions softly;
    static StringBuilder descriptionReportBuilder;
    static Consumer<Description> descriptionConsumer;
    public static final String VANILLA_GRID_INPUT = """
                                                    123
                                                    456
                                                    789
                                                    """;

    @BeforeEach
    void setUp() {
        setDescriptionConsumer(descriptionConsumer);
    }

    @Test
    @DisplayName("Grid should be generated from a String")
    void gridShouldBeGeneratedFromAString() {
        gridCoordinateAssertion(2, 0, 3, VANILLA_GRID_INPUT);
        gridCoordinateAssertion(0, 1, 4, VANILLA_GRID_INPUT);
        softly.assertAll();
    }

    private void gridCoordinateAssertion(int x, int y, int expected, String gridData) {
        Grid underTest = new Grid(gridData);
        int result = underTest.getCoordinateValue(x, y);
        softly.assertThat(result)
              .as("\nGiven grid data of:\n%s\nValue of coordinate %d, %d should be %d.", gridData, x, y, expected)
              .isEqualTo(expected);
    }

    @BeforeAll
    static void suiteSetup() {
        softly = new SoftAssertions();
        descriptionReportBuilder = new StringBuilder(String.format("Assertions:%n"));
        descriptionConsumer = desc -> descriptionReportBuilder.append(String.format("-- %s%n", desc.toString()
                                                                                                   .replace("\n", "\n   ")));
    }

    @AfterAll
    static void printAssertionsReport() {
        System.out.println(descriptionReportBuilder.toString());

    }
}