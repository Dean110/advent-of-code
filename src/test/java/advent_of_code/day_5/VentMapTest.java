package advent_of_code.day_5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VentMapTest {

    private VentMap underTest;

    private void createOverlappedPoint(int x, int y) {
        underTest.plotPoint(x, y);
        underTest.plotPoint(x, y);
    }

    @BeforeEach
    void setUp() {
        underTest = new VentMap(10, 10);
    }

    @Test
    public void countOverlappedPoints() {
        int x = 0;
        int y = 0;
        createOverlappedPoint(x, y);
        assertThat(underTest.countOverlappedPoints()).isEqualTo(1);
    }


    @Test
    public void countAnotherSetOfOverLappedPoints() {
        createOverlappedPoint(0, 0);
        createOverlappedPoint(0, 1);
        assertThat(underTest.countOverlappedPoints()).isEqualTo(2);
    }
}