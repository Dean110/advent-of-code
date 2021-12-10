package advent_of_code.day_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BingoBoardTest {

    private BingoBoard underTest;

    @BeforeEach
    void setUp() {
        underTest = new BingoBoard(IntStream.range(0,25).boxed().toList());
    }

    @Test
    public void rowWinner(){

        IntStream.range(0,5).forEach(i -> underTest.markNumber(i));
        assertThat(underTest.isAWinner()).isTrue();
    }
    @Test
    public void rowLoser(){
        IntStream.range(25,30).forEach(i -> underTest.markNumber(i));
        assertThat(underTest.isAWinner()).isFalse();
    }
    @Test
    public void columnWinner(){
        underTest.markNumber(0);
        underTest.markNumber(5);
        underTest.markNumber(10);
        underTest.markNumber(15);
        underTest.markNumber(20);
        assertThat(underTest.isAWinner()).isTrue();
    }
    @Test
    public void columnLoser(){
        underTest.markNumber(0);
        underTest.markNumber(5);
        underTest.markNumber(10);
        underTest.markNumber(15);
        underTest.markNumber(21);
        assertThat(underTest.isAWinner()).isFalse();
    }

}
