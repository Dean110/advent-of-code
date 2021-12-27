package advent_of_code.day_12;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
class CaveMapperTest {
    @InjectSoftAssertions
    private SoftAssertions softly;

    @Nested
    @DisplayName("Maps String input into network of caves")
    class MapInputIntoCaveNetwork {

        @Test
        @DisplayName("One route")
        void oneRoute() {
            routeCountAssertion(1, """
                                   start-A
                                   A-end
                                   """);
        }

        @Test
        @DisplayName("Two routes")
        void twoRoutes() {
            routeCountAssertion(2, """
                                   start-A
                                   A-b
                                   A-end
                                   """);
            routeCountAssertion(2, """
                                   start-A
                                   start-b
                                   b-end
                                   A-end
                                        """);
        }

        private void routeCountAssertion(int expectedRouteCount, String rawInput) {
            CaveMapper underTest = new CaveMapper(rawInput);
            int routeCount = underTest.countStartToEndRoutes();
            softly.assertThat(routeCount).isEqualTo(expectedRouteCount);
        }
    }

}