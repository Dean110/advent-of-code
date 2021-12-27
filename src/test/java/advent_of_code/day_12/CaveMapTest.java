package advent_of_code.day_12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CaveMapTest {

    private CaveMap underTest;
    private Cave testCave;

    @BeforeEach
    void setUp() {
        underTest = new CaveMap();
        testCave = new Cave("start");
        underTest.add(testCave);
    }

    @Test
    @DisplayName("Be able to add cave to cave map.")
    void beAbleToAddCaveToCaveMap() {
        Collection<Cave> result = underTest.getCaves();
        assertThat(result).containsExactly(testCave);
    }


    @Test
    @DisplayName("Be able to retrieve cave by its name.")
    void beAbleToRetrieveCaveByItsName() {
       Cave result = underTest.retrieveCave("start");
       assertThat(result).isEqualTo(testCave);
    }
}