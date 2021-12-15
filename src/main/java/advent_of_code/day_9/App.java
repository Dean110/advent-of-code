package advent_of_code.day_9;

import advent_of_code.input_handling.TextFileReader;

import java.nio.file.Path;
import java.util.*;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";
    public static List<List<Integer>> integerGrid;

    public static void main(String[] args) {
        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));

        List<String> lineInputs = List.of(inputReader.readFile().split("\n"));

        integerGrid = lineInputs.stream()
                .map(str -> str.split(""))
                .toList()
                .stream()
                .map(array -> Arrays.stream(array).map(Integer::parseInt).toList())
                .toList();
        List<Integer> basinSizes = new ArrayList<>();
        for (int verticalIndex = 0; verticalIndex < integerGrid.size(); verticalIndex++) {
            for (int horizontalIndex = 0; horizontalIndex < integerGrid.get(0).size(); horizontalIndex++) {
                int candidate = integerGrid.get(verticalIndex).get(horizontalIndex);
                System.out.println(String.format("V Index: %d, H Index: %d", verticalIndex, horizontalIndex));
                if (isBottomRightCorner(verticalIndex, horizontalIndex)) {
                    if (candidate < toTheLeft(verticalIndex, horizontalIndex) &&
                            candidate < toTheTop(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;

                }
                if (isBottomLeftCorner(verticalIndex, horizontalIndex)) {
                    if (candidate < toTheRight(verticalIndex, horizontalIndex) &&
                            candidate < toTheTop(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (isUpperLeftCorner(verticalIndex, horizontalIndex)) {
                    if (candidate < integerGrid.get(verticalIndex).get(horizontalIndex + 1) &&
                            candidate < integerGrid.get(verticalIndex + 1).get(horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (isUpperRightCorner(verticalIndex, horizontalIndex)) {
                    if (candidate < toTheLeft(verticalIndex, horizontalIndex) &&
                            candidate < toTheBottom(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (isLastVerticalRow(verticalIndex)) {
                    if (candidate < toTheLeft(verticalIndex, horizontalIndex) &&
                            candidate < toTheRight(verticalIndex, horizontalIndex) &&
                            candidate < toTheTop(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (isLastHorizontalRow(horizontalIndex)) {
                    if (candidate < toTheLeft(verticalIndex, horizontalIndex) &&
                            candidate < toTheTop(verticalIndex, horizontalIndex) &&
                            candidate < toTheBottom(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (isTopRow(verticalIndex)) {
                    if (candidate < toTheBottom(verticalIndex, horizontalIndex) &&
                            candidate < toTheLeft(verticalIndex, horizontalIndex) &&
                            candidate < toTheRight(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (isFirstVerticalColumn(horizontalIndex)) {
                    if (candidate < toTheRight(verticalIndex, horizontalIndex) &&
                            candidate < toTheTop(verticalIndex, horizontalIndex) &&
                            candidate < toTheBottom(verticalIndex, horizontalIndex)) {
                        calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);
                    }
                    continue;
                }
                if (candidate < toTheRight(verticalIndex, horizontalIndex) &&
                        candidate < toTheLeft(verticalIndex, horizontalIndex) &&
                        candidate < toTheTop(verticalIndex, horizontalIndex) &&
                        candidate < toTheBottom(verticalIndex, horizontalIndex)) {
                    calculateBasinSize(basinSizes, verticalIndex, horizontalIndex);

                }
            }
        }

        System.out.println(basinSizes.stream().sorted(Collections.reverseOrder()).limit(3).mapToInt(Integer::intValue).reduce(1, (a,b)-> a * b));
    }

    private static void calculateBasinSize(List<Integer> basinSizes, int verticalIndex, int horizontalIndex) {
        Map<Coordinate, Integer> basinSpots = new HashMap<>();
        basinSizes.add(countBasinSpots(verticalIndex, horizontalIndex, basinSpots));
    }

    private static Integer countBasinSpots(int verticalIndex, int horizontalIndex, Map<Coordinate, Integer> basinSpots) {
        Integer basinSpotValue = getGridPositionValue(verticalIndex, horizontalIndex);
        if (basinSpotValue != 9) {
            basinSpots.put(new Coordinate(verticalIndex, horizontalIndex), basinSpotValue);
        }else return 0;

        if (basinSpotValue < toTheLeft(verticalIndex, horizontalIndex)) {
            countBasinSpots(verticalIndex, horizontalIndex - 1, basinSpots);
        }
        if(basinSpotValue < toTheTop(verticalIndex,horizontalIndex)){
            countBasinSpots(verticalIndex - 1, horizontalIndex, basinSpots);
        }
        if(basinSpotValue < toTheRight(verticalIndex, horizontalIndex)){
            countBasinSpots(verticalIndex, horizontalIndex+1, basinSpots);
        }
        if(basinSpotValue < toTheBottom(verticalIndex,horizontalIndex)){
            countBasinSpots(verticalIndex+1,horizontalIndex, basinSpots);
        }
        return basinSpots.size();
    }

    public record Coordinate(int verticalIndex, int horizontalIndex){}

    ;

    private static boolean isFirstVerticalColumn(int horizontalIndex) {
        return horizontalIndex == 0;
    }

    private static int toTheBottom(int verticalIndex, int horizontalIndex) {
        return getGridPositionValue(verticalIndex + 1, horizontalIndex);
    }

    private static boolean isUpperRightCorner(int verticalIndex, int horizontalIndex) {
        return isTopRow(verticalIndex) && isLastHorizontalRow(horizontalIndex);
    }

    private static boolean isTopRow(int verticalIndex) {
        return verticalIndex == 0;
    }


    private static Integer toTheLeft(int verticalIndex, int horizontalIndex) {
        return getGridPositionValue(verticalIndex, horizontalIndex - 1);
    }

    private static boolean isBottomLeftCorner(int verticalIndex, int horizontalIndex) {
        return isLastVerticalRow(verticalIndex) && horizontalIndex == 0;
    }

    private static Integer toTheTop(int verticalIndex, int horizontalIndex) {
        return getGridPositionValue(verticalIndex - 1, horizontalIndex);
    }

    private static Integer toTheRight(int verticalIndex, int horizontalIndex) {
        return getGridPositionValue(verticalIndex, horizontalIndex + 1);
    }

    private static Integer getGridPositionValue(int verticalIndex, int horizontalIndex) {
        int value = 0;
        try {
            value += integerGrid.get(verticalIndex).get(horizontalIndex);
        } catch (Exception e) {
            return 9;
        }
        return value;
    }

    private static boolean isBottomRightCorner(int verticalIndex, int horizontalIndex) {
        return isLastVerticalRow(verticalIndex) && isLastHorizontalRow(horizontalIndex);
    }

    private static boolean isLastHorizontalRow(int horizontalIndex) {
        return horizontalIndex == integerGrid.get(0).size() - 1;
    }

    private static boolean isLastVerticalRow(int verticalIndex) {
        return verticalIndex == integerGrid.size() - 1;
    }

    private static boolean isUpperLeftCorner(int verticalIndex, int horizontalIndex) {
        return verticalIndex == 0 && horizontalIndex == 0;
    }
}


