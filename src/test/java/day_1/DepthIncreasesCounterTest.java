package day_1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthIncreasesCounterTest {

    @Test
    public void givenTwoReadingsIncreasingInDepthReturns1(){
        DepthIncreasesCounter underTest = new DepthIncreasesCounter();
        int result = underTest.calculate(List.of(1, 2));
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void givenThreeReadingsIncreasingInDepthReturns2(){
        DepthIncreasesCounter underTest = new DepthIncreasesCounter();
        int result = underTest.calculate(List.of(1, 2, 3));
        assertThat(result).isEqualTo(2);
    }
    @Test
    public void givenThreeReadingsWithOneIncreasingInDepthReturns1(){
        DepthIncreasesCounter underTest = new DepthIncreasesCounter();
        int result = underTest.calculate(List.of(1, 3, 2));
        assertThat(result).isEqualTo(1);
    }
}
