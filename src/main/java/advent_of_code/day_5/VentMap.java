package advent_of_code.day_5;

import java.util.Arrays;

public class VentMap {

    int[][] map;

    public VentMap(int width, int height) {
        map = new int[width][height];
    }

    public int countOverlappedPoints() {
        return (int) Arrays.stream(map).flatMapToInt(Arrays::stream)
                .filter(count -> count >= 2)
                .count();
    }

    public void plotPoint(int x, int y) {
        map[x][y]++;
    }
}
