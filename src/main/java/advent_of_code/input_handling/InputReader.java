package advent_of_code.input_handling;

import java.util.List;

public interface InputReader {
    List<Integer> processDepthInputs();

    List<String> processStringInputs();
}
