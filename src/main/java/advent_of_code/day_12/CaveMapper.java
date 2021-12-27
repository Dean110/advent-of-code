package advent_of_code.day_12;

import java.util.List;

public class CaveMapper {
    private CaveMap caves = new CaveMap();

    public CaveMapper(String rawInput) {
        parseInput(rawInput);
    }

    private void parseInput(String rawInput) {
        List<String> inputs = List.of(rawInput.split("\n"));
        createCaves(inputs);
    }

    private void createCaves(List<String> inputs) {
        inputs.stream()
              .map(input -> input.split("-"))
              .forEach(connection -> createCaveConnection(connection[0], connection[1]));
    }

    private void createCaveConnection(String terminusA, String terminusB) {
        Cave startingCave = caves.retrieveCave(terminusA);
        if(startingCave == null){
            startingCave = new Cave(terminusA);
            caves.add(startingCave);
        }
        Cave destinationCave = caves.retrieveCave(terminusB);
        if(destinationCave == null){
            destinationCave = new Cave(terminusB);
            caves.add(destinationCave);
        }
        startingCave.addConnectedCave(destinationCave);
    }

    public int countStartToEndRoutes() {
        return caves.getCaves().size()-2;
    }
}
