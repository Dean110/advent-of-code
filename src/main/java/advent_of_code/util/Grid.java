package advent_of_code.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Grid {
    private List<List<Integer>> grid;

    public Grid(String gridData) {
        grid = Arrays.stream(gridData.split("\n"))
                     .collect(Collectors.toList())
                     .stream()
                     .map(str -> str.split(""))
                     .map(strings -> Arrays.stream(strings)
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toList()))
                     .collect(Collectors.toList());
    }

    public int getCoordinateValue(int x, int y) {
        return grid.get(y)
                   .get(x);
    }

    public int fetchNeighboringValue(int x, int y, String direction) {
        try {
            return switch (direction) {
                case "NW" -> getCoordinateValue(x - 1, y - 1);
                case "N" -> getCoordinateValue(x, y - 1);
                case "NE" -> getCoordinateValue(x + 1, y - 1);
                case "W" -> getCoordinateValue(x - 1, y);
                case "E" -> getCoordinateValue(x + 1, y);
                case "SW" -> getCoordinateValue(x - 1, y + 1);
                case "S" -> getCoordinateValue(x, y + 1);
                case "SE" -> getCoordinateValue(x + 1, y + 1);
                default -> Integer.MIN_VALUE;
            };
        }catch (IndexOutOfBoundsException e){
            return Integer.MIN_VALUE;
        }

    }

    @Override
    public String toString() {
        return grid.stream()
                .map(list -> list.stream()
                        .map(i -> i.toString())
                        .collect(Collectors.joining("")))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid1 = (Grid) o;

        return grid.equals(grid1.grid);
    }

    @Override
    public int hashCode() {
        return grid.hashCode();
    }
}
