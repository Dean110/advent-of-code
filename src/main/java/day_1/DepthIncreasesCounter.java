package day_1;

import java.util.List;

public class DepthIncreasesCounter {
    public DepthIncreasesCounter() {
    }

    public int calculate(List<Integer> depths) {
        int increases = 0;
        for(int i = 0; i < depths.size() - 1; i++){
            if(depths.get(i) < depths.get(i+1)) increases++;
        }
        return increases;
    }
}
