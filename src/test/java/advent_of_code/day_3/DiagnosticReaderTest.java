package advent_of_code.day_3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class DiagnosticReaderTest {
    @Test
    public void givenAListOfBinaryNumbersReturnsDecimalPowerConsumption() {
        assertAll(
                () -> assertPowerConsumptionReading(0, "00000", "00000", "11111"),
                () -> assertPowerConsumptionReading(0, "11111", "11111", "11111"),
                () -> assertPowerConsumptionReading(30, "00001", "00000", "11111")
        );
    }

    @Test
    public void lifeSupport() {
        assertAll(
                () -> assertLifeSupportRating(230,
                        "00100", "11110", "10110", "10111", "10101", "01111", "00111", "11100", "10000",
                        "11001", "00010", "01010"),
                () -> assertLifeSupportRating(0, "10000", "11111", "00000"),
                () -> assertLifeSupportRating(31, "00001", "00000", "11111")
        );
    }

    private void assertLifeSupportRating(int expected, String... diagnostics) {
        DiagnosticReader underTest = new DiagnosticReader();
        int result = underTest.computeLifeSupportRating(Arrays.asList(diagnostics));
        assertThat(result).isEqualTo(expected);
    }

    private void assertPowerConsumptionReading(int expected, String... diagnostics) {
        DiagnosticReader underTest = new DiagnosticReader();
        int result = underTest.computePowerConsumption(Arrays.asList(diagnostics));
        assertThat(result).isEqualTo(expected);
    }
}
