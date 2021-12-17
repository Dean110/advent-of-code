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
        return grid.get(y).get(x);
    }
}
