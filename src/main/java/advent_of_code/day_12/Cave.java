package advent_of_code.day_12;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cave {
    private Set<Cave> connectedCaves;
    private String name;

    public Cave(String name) {
        connectedCaves = new HashSet<>();
        this.name = name;
    }

    public Set<Cave> getConnectedCaves() {
        return connectedCaves;
    }

    public void addConnectedCave(Cave connectedCave) {
        connectedCaves.add(connectedCave);
        connectedCave.getConnectedCaves().add(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cave{ name: \'" + name + "\', connectedCaves: \'" +
                connectedCaves.stream().map(c -> c.name).collect(Collectors.joining(", ")) +
                "\'}";
    }
}
