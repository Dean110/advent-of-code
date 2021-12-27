package advent_of_code.day_12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CaveTest {

    @Test
    @DisplayName("Cave shouldBeAbleTOAddConnectedCaves")
    void caveShouldBeAbleToAddConnectedCaves() {
        Cave underTest = new Cave("A");
        Set<Cave> result = underTest.getConnectedCaves();
        Cave connectedCave = new Cave("start");
        underTest.addConnectedCave(connectedCave);
        assertThat(result).contains(connectedCave);
        assertThat(connectedCave.getConnectedCaves()).contains(underTest);
    }



}