package day_1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SlidingWindowDepthIncreasesCounterTest {
    @Test
    public void givenFourReadingsIncreasingInDepthReturns1(){
        DepthIncreasesCounter underTest = new SlidingWindowDepthIncreasesCounter();
        int result = underTest.calculate(List.of(1, 2,3,4));
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void givenFiveReadingsIncreasingInDepthReturns1(){
        DepthIncreasesCounter underTest = new SlidingWindowDepthIncreasesCounter();
        int result = underTest.calculate(List.of(1, 2,3,4, 5));
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void givenFiveReadingsWithOneWindowIncreasingInDepthReturns1(){
        DepthIncreasesCounter underTest = new SlidingWindowDepthIncreasesCounter();
        int result = underTest.calculate(List.of(1, 2,3,5, 1));
        assertThat(result).isEqualTo(1);
    }

}
