package advent_of_code.day_11;

import advent_of_code.util.Grid;

import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static advent_of_code.util.Grid.Coordinates;

public class OctopiTracker {
    private Grid grid;
    private int flashCount;

    public OctopiTracker(String gridInputs) {
        grid = new Grid(gridInputs);
    }

    public void tick() {
        Set<Entry<Coordinates, Integer>> octopi = grid.plots();
        octopi.stream()
              .forEach(octopus -> grid.setValueAtCoordinate(
                      octopus.getKey()
                             .x(), octopus.getKey()
                                          .y(), octopus.getValue() + 1));
        flashOctopi(octopi);
        octopi.stream()
              .filter(o -> o.getValue() < 0)
              .forEach(o -> grid.setValueAtCoordinate(o.getKey()
                                                       .x(), o.getKey()
                                                              .y(), 0));

    }

    private void flashOctopi(Set<Entry<Coordinates, Integer>> octopi) {
        AtomicInteger count = new AtomicInteger(0);
        var loadedOctopi = octopi.stream()
                                 .filter(octopus -> octopus.getValue() > 9)
                                 .collect(Collectors.toList());

        loadedOctopi.stream()
                    .forEach(o -> {
                        grid.setValueAtCoordinate(o.getKey()
                                                   .x(), o.getKey()
                                                          .y(), Integer.MIN_VALUE);
                        incrementNeighbors(o);
                        count.getAndIncrement();

                    });

        if(count.get()==grid.gridHeight*grid.gridLength) throw new UnsupportedOperationException();
        if (count.get() > 0) {
            flashOctopi(octopi);
        }
        flashCount += count.get();
    }

    private void incrementNeighbors(Entry<Coordinates, Integer> loadedOctopus) {
        Coordinates octopusLocation = loadedOctopus.getKey();
        for (int x = octopusLocation.x() - 1; x <= octopusLocation.x() + 1; x++) {
            for (int y = octopusLocation.y() - 1; y <= octopusLocation.y() + 1; y++) {
                if ((x == octopusLocation.x() && y == octopusLocation.y()) || x < 0 || x >= grid.gridLength || y < 0 || y >= grid.gridHeight) {
                } else {
                    grid.setValueAtCoordinate(x, y, grid.getValueAtCoordinate(x, y) + 1);

                }
            }
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public int getFlashCount() {
        return flashCount;
    }
}
