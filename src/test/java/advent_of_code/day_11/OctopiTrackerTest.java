package advent_of_code.day_11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OctopiTrackerTest {
    @Test
    @DisplayName("OctopiTrackerShouldIncrementOctopiInGrid")
    void octopiTrackerShouldIncrementOctopiInGrid() {
        String input = """
                       111
                       111
                       111""";
        OctopiTracker underTest = new OctopiTracker(input);
        underTest.tick();
        assertThat(underTest.getGrid().toString()).isEqualTo("""
                                                             222
                                                             222
                                                             222""");
    }

    @Test
    @DisplayName("tick() should trigger 'flashes'.")
    void tickShouldTriggerFlashes() {
        String input = """
                       11111
                       19991
                       19191
                       19991
                       11111""";
        OctopiTracker underTest = new OctopiTracker(input);
        underTest.tick();
        assertThat(underTest.getGrid().toString()).isEqualTo("""
                                                             34543
                                                             40004
                                                             50005
                                                             40004
                                                             34543""");
    }
}