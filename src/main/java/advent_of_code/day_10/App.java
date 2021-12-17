package advent_of_code.day_10;

import java.util.Arrays;

public class App {
    public static final String INPUT_TXT_PATH = "src/main/resources/inputs.txt";

    public static void main(String[] args) {
        System.out.println(Arrays.stream("HI".split(""))
                                 .toList());
//        TextFileReader inputReader = new TextFileReader(Path.of(INPUT_TXT_PATH));
//
//        List<String> lineInputs = List.of(inputReader.readFile().split("\n"));
//
//        InputValidator validator = new InputValidator();
//
//        int total = 0;
//        List<Long> scores = new ArrayList<>();
//        for (String input : lineInputs) {
//            char invalidChar = validator.evaluateExpression(input, (char) 0);
//            if (invalidChar != 0) continue;
//            long score = validator.completeLine(input, (char) 0);
//            scores.add(score);
//        }
//        System.out.println(scores);
//        long medianScore = (long) scores.stream().sorted().skip(Math.max(0, ((scores.size() + 1) / 2) - 1))
//                .limit(1 + (1 + scores.size()) % 2).mapToLong(Long::longValue).average().getAsDouble();
//        System.out.println(medianScore);
    }

}



