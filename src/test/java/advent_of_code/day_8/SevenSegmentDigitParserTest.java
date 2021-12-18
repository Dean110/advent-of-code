package advent_of_code.day_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/*
  0:      1:      2:      3:      4:
 aaaa    ....    aaaa    aaaa    ....
b    c  .    c  .    c  .    c  b    c
b    c  .    c  .    c  .    c  b    c
 ....    ....    dddd    dddd    dddd
e    f  .    f  e    .  .    f  .    f
e    f  .    f  e    .  .    f  .    f
 gggg    ....    gggg    gggg    ....

  5:      6:      7:      8:      9:
 aaaa    aaaa    aaaa    aaaa    aaaa
b    .  b    .  .    c  b    c  b    c
b    .  b    .  .    c  b    c  b    c
 dddd    dddd    ....    dddd    dddd
.    f  e    f  .    f  e    f  .    f
.    f  e    f  .    f  e    f  .    f
 gggg    gggg    ....    gggg    gggg

 2 -> "1"; 3 -> "7"; 4 -> "4"; 5 -> "2", "3", "5"; 6 -> "0", "6", "9"; 7 -> "8"
 - Finding "1", "7", "4", "8" is simple, unique segment counts.
 - Finding "3" is done comparing the 5 segment digits to "1": "3" will differ by 3 segments whereas the other two will have 4 segments that don't match.
 - Finding "9" is done comparing the 6 segment digits to "3": "9" will differ by 1 segments whereas the other two will have 3 segments that don't match.

 At this point we have "0", "2", "5", "6" left.
 - "6" and "0" can be found by comparing to "1": "0" will have 4 segments different, whereas "6" will have 6 segments different.
 - "2" and "5" can be found by comparing to "4": "2" will have 5 segments different, whereas "5" will have 4 segments different.

 Segment C is found by comparing "0" to "6"
 Segment D is found by comparing "0" to "8".
 Segment F is the leftover unknown segment for "1".
 Segment A is the leftover unknown segment for "7".
 Segment B is the leftover unknown segment for "4".
 Segment G is the leftover unknown segment for "5".
 Segment E is the leftover unknown segment.
 */
class SevenSegmentDigitParserTest {
    public static final String VANILLA_CIPHER = "abcefg cf acdeg acdfg bcdf abdfg abdefg acf abcdefg abcdfg";

    private SevenSegmentDigitParser underTest;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void givenCipher_BuildsDigitMapper() {
        assertAll(
                () -> sevenSegmentAssertion("0", "abcefg"),
                () -> sevenSegmentAssertion("1", "cf"),
                () -> sevenSegmentAssertion("2", "acdeg"),
                () -> sevenSegmentAssertion("3", "acdfg"),
                () -> sevenSegmentAssertion("4", "bcdf"),
                () -> sevenSegmentAssertion("5", "abdfg"),
                () -> sevenSegmentAssertion("6", "abdefg"),
                () -> sevenSegmentAssertion("7", "acf"),
                () -> sevenSegmentAssertion("8", "abcdefg"),
                () -> sevenSegmentAssertion("9", "abcdfg")
        );
    }


    private void sevenSegmentAssertion(String expected, String encodedDigit) {
        underTest = new SevenSegmentDigitParser(VANILLA_CIPHER);
        String result = underTest.parse(encodedDigit);
        assertThat(result)
                .withFailMessage("Decoding for %s failed! :: Code - %s, Expected - %s", expected, encodedDigit, result)
                .isEqualTo(expected);
    }
}