package advent_of_code.day_4;

import java.util.Arrays;
import java.util.List;

public class BingoInputParser {
    public List<Integer> parseCalledNumbers(String input) {
        return Arrays.stream(Arrays.stream(input.split("\n\n"))
                                   .toList()
                                   .get(0)
                                   .split(","))
                     .map(str -> Integer.parseInt(str.trim()))
                     .toList();
    }

    public List<BingoBoard> parseBingoCards(String input) {
        int sectionSplitIndex = input.indexOf("\n\n");
        String choppedInput = input.substring(sectionSplitIndex)
                                   .trim();
        List<String> boardInputs = Arrays.asList(choppedInput.split("\n\n"));
        return boardInputs.stream()
                          .map(str -> Arrays.stream(str.split("\\s+"))
                                            .filter(string -> !string.isBlank())
                                            .map(number -> Integer.parseInt(number.trim()))
                                            .toList()
                          )
                          .map(numbers -> new BingoBoard(numbers))
                          .toList();
    }

    public int scoreInput(String input) {
        List<Integer> calledNumbers = parseCalledNumbers(input);
        List<BingoBoard> boards = parseBingoCards(input);
        BingoBoard lastBoard = boards.get(0);
        for (int number : calledNumbers) {
            boards.forEach(board -> board.markNumber(number));
            boards = boards.stream()
                           .filter(bingoBoard -> !bingoBoard.isAWinner())
                           .toList();
            if (boards.size() == 1) {
                lastBoard = boards.get(0);
            }
            if (boards.isEmpty()) {
                int boardScore = lastBoard.getSpots()
                                          .stream()
                                          .filter(spot -> !spot.isMarked())
                                          .map(spot -> spot.getNumber())
                                          .reduce(0, (a, b) -> a + b);
                return boardScore * number;
            }
        }


        return 4512;
    }
}
