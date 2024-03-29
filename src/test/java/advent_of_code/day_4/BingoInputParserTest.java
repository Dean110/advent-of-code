package advent_of_code.day_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BingoInputParserTest {
    private final String input = """
                                 7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
                                                 
                                 22 13 17 11  0
                                  8  2 23  4 24
                                 21  9 14 16  7
                                  6 10  3 18  5
                                  1 12 20 15 19
                                                 
                                  3 15  0  2 22
                                  9 18 13 17  5
                                 19  8  7 25 23
                                 20 11 10 24  4
                                 14 21 16 12  6
                                                 
                                 14 21 17 24  4
                                 10 16 15  9 19
                                 18  8 23 26 20
                                 22 11 13  6  5
                                  2  0 12  3  7
                                 """;
    private BingoInputParser underTest;

    @BeforeEach
    void setUp() {
        underTest = new BingoInputParser();
    }

    @Test
    public void parsesCalledNumbers() {
        List<Integer> result = underTest.parseCalledNumbers(input);
        assertThat(result).containsExactly(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1);
    }

    @Test
    public void parseBingoCards() {
        String testInput = """
                           0,1,2,3,4,5
                                           
                            0  1  2  3  4
                            5  6  7  8  9
                           10 11 12 13 14
                           15 16 17 18 19
                           20 21 22 23 24
                           """;
        List<BingoBoard> result = underTest.parseBingoCards(testInput);
        assertThat(result).containsExactly(new BingoBoard(IntStream.range(0, 25)
                                                                   .boxed()
                                                                   .toList()));
    }

    @Test
    public void scoreInput() {
        int result = underTest.scoreInput(input);
        assertThat(result).isEqualTo(1924);
    }
}
