package advent_of_code.day_12;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CaveMap {
    private Map<String,Cave> caves = new HashMap<>();

    public void add(Cave cave) {
caves.put(cave.getName(),cave);
    }

    public Collection<Cave> getCaves() {
        return caves.values();
    }

    public Cave retrieveCave(String caveName) {
        return caves.get(caveName);
    }
}
