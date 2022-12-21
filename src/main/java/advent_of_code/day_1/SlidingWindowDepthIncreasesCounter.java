package advent_of_code.day_1;

import java.util.List;

public class SlidingWindowDepthIncreasesCounter implements DepthIncreasesCounter {
    @Override
    public int calculate(List<Integer> depths) {
        int increases = 0;
        for (int i = 4; i <= depths.size(); i++) {
            int initialDepth = depths.subList(i - 4, i - 1)
                                     .stream()
                                     .reduce(0, Integer::sum);
            int newDepth = depths.subList(i - 3, i)
                                 .stream()
                                 .reduce(0, Integer::sum);
            if (newDepth > initialDepth) increases++;
        }
        return increases;
    }
}
