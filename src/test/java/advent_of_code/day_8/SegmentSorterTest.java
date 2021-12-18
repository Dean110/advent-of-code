package advent_of_code.day_8;
//         Segment C is found by comparing "0" to "6"
//         Segment D is found by comparing "0" to "8".
//         Segment F is the leftover unknown segment for "1".
//         Segment A is the leftover unknown segment for "7".
//         Segment B is the leftover unknown segment for "4".
//         Segment G is the leftover unknown segment for "5".
//         Segment E is the leftover unknown segment.

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static advent_of_code.day_8.SevenSegmentDigitParserTest.VANILLA_CIPHER;

public class SegmentSorterTest {
    public static final Map<String, String> VANILLA_ENCODED_DIGITS = Map.of(
            "abcefg", "0",
            "cf", "1",
            "acdeg", "2",
            "acdfg", "3",
            "bcdf", "4",
            "abdfg", "5",
            "abdefg", "6",
            "acf", "7",
            "abcdefg", "8",
            "abcdfg", "9");

    private SegmentSorter underTest;

    @BeforeEach
    public void setUp() {
        underTest = new SegmentSorter(VANILLA_CIPHER, VANILLA_ENCODED_DIGITS);
    }

    @Test
    public void checkSegments() {
        Map<String, String> segmentMap = underTest.getSegmentMap();
//        assertThat(segmentMap.)
    }
}
