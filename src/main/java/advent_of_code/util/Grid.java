package advent_of_code.util;

import java.util.*;
import java.util.stream.Collectors;

public class Grid {
    public Set<Map.Entry<Coordinates, Integer>> plots() {
        return grid.entrySet();
    }

    public record Coordinates(int x, int y) {
        public static Coordinates of(int x, int y) {
            return new Coordinates(x, y);
        }
    }

    public Map<Coordinates, Integer> grid;
    public final int gridLength;
    public final int gridHeight;

    public Grid(String gridData) {
        List<List<Integer>> parsedData = Arrays.stream(gridData.split("\n"))
                                               .collect(Collectors.toList())
                                               .stream()
                                               .map(str -> str.split(""))
                                               .map(strings -> Arrays.stream(strings)
                                                                     .map(Integer::parseInt)
                                                                     .collect(Collectors.toList()))
                                               .collect(Collectors.toList());
        gridLength = parsedData.get(0)
                               .size();
        gridHeight = parsedData.size();
        grid = new LinkedHashMap<>();
        for (int y = 0; y < gridHeight; y++) {
            for (int x = 0; x < gridLength; x++) {
                grid.put(Coordinates.of(x, y), parsedData.get(y)
                                                         .get(x));
            }
        }
    }

    public Integer getValueAtCoordinate(int x, int y) {
        return grid.get(Coordinates.of(x, y));
    }

    public void setValueAtCoordinate(int x, int y, int newValue) {
        if (x < gridLength && x >= 0 && y < gridHeight && y >= 0) grid.put(Coordinates.of(x, y), newValue);
    }

    public Set<Coordinates> coordinates() {
        return grid.keySet();
    }

    public int fetchNeighboringValue(int x, int y, String direction) {
        Optional<Integer> valueOptional = Optional.ofNullable(
                switch (direction) {
                    case "NW" -> getValueAtCoordinate(x - 1, y - 1);
                    case "N" -> getValueAtCoordinate(x, y - 1);
                    case "NE" -> getValueAtCoordinate(x + 1, y - 1);
                    case "W" -> getValueAtCoordinate(x - 1, y);
                    case "E" -> getValueAtCoordinate(x + 1, y);
                    case "SW" -> getValueAtCoordinate(x - 1, y + 1);
                    case "S" -> getValueAtCoordinate(x, y + 1);
                    case "SE" -> getValueAtCoordinate(x + 1, y + 1);
                    default -> throw new InvalidDirectionException(String.format("\"%s\" is an invalid direction.", direction));
                });
        if (valueOptional.isEmpty())
            throw new GridCoordinateAreInvalidException(String.format("%d, %d does not have a %s neighbor.", x, y, direction));
        return valueOptional.get();
    }

    @Override
    public String toString() {
        int yIndex = 0;
        String s = "";
        for (Map.Entry<Coordinates, Integer> entry : grid.entrySet()) {
            if (entry.getKey()
                     .y() != yIndex) {
                yIndex++;
                s += "\n";
            }
            s += entry.getValue();
        }
        return s;
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

    private class InvalidDirectionException extends RuntimeException {
        public InvalidDirectionException(String message) {
            super(message);
        }
    }

    private class GridCoordinateAreInvalidException extends RuntimeException {
        public GridCoordinateAreInvalidException(String message) {
            super(message);
        }
    }
}
