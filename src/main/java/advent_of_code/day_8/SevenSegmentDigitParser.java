package advent_of_code.day_8;

import java.util.*;
import java.util.stream.Collectors;

/*
 * String cipher -> List<String> signalPatterns -> Map<String, String> segments -> Map<String, String> displayDigits
 */
public class SevenSegmentDigitParser {
    private final List<String> signalPatterns;
    private Map<String, String> displayDigits = new HashMap<>(); // signalPattern, String digit

    public SevenSegmentDigitParser(String cipher) {
        signalPatterns = Arrays.stream(cipher.split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        populateMaps();
    }

    private void populateMaps() {
        populatePatterns();
    }

    private void populatePatterns() {
        /*
         - Finding "1", "7", "4", "8" is simple, unique segment counts.
         - Finding "3" is done comparing the 5 segment digits to "1": "3" will differ by 3 segments whereas the other two will have 4 segments that don't match.
         - Finding "9" is done comparing the 6 segment digits to "3": "9" will differ by 1 segments whereas the other two will have 3 segments that don't match.

         At this point we have "0", "2", "5", "6" left.
         - "6" and "0" can be found by comparing to "1": "0" will have 4 segments different, whereas "6" will have 6 segments different.
         - "2" and "5" can be found by comparing to "4": "2" will have 5 segments different, whereas "5" will have 4 segments different.

         */
        populateUniquePatterns();
        populateComparableDigits("3", 5, "1", 3);
        populateComparableDigits("9", 6, "3", 1);
        populateComparableDigits("6", 6, "1", 6);
        populateComparableDigits("0", 6, "1", 4);
        populateComparableDigits("2", 5, "4", 5);
        displayDigits.put("5", signalPatterns.stream().filter(p -> p.length() == 5).findFirst().get());
    }


    private void populateUniquePatterns() {
        displayDigits.put("1", signalPatterns.get(0));
        displayDigits.put("7", signalPatterns.get(1));
        displayDigits.put("4", signalPatterns.get(2));
        displayDigits.put("8", signalPatterns.get(9));
    }

    private void populateComparableDigits(String targetDigit, int targetDigitPatternLength, String keyDigit, int differenceCount) {
        String keyPattern = displayDigits.get(keyDigit);
        List<String> candidatePatterns = signalPatterns.stream()
                .filter(pattern -> pattern.length() == targetDigitPatternLength)
                .toList();
        String foundPattern = candidatePatterns.stream()
                .filter(ptrn -> differingSegmentsCount(keyPattern, ptrn) == differenceCount)
                .findFirst()
                .get();
        displayDigits.put(targetDigit, foundPattern);
        signalPatterns.remove(foundPattern);
    }

    private int differingSegmentsCount(String patternA, String patternB) {
        int count = 0;
        for (int i = 0; i <= 7; i++) {
            String test = Character.toString(i + 97);
            if (patternA.contains(test) != patternB.contains(test)) count++;
        }
        return count;
    }


    public String parse(String signalPattern) {
        return displayDigits.entrySet()
                .stream()
                .filter(entry -> differingSegmentsCount(entry.getValue(), signalPattern) == 0)
                .findFirst()
                .get()
                .getKey();
    }


}
