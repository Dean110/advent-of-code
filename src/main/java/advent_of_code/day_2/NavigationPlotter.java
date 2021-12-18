package advent_of_code.day_2;

import java.util.List;

public class NavigationPlotter {
    public int computeCommands(List<String> commands) {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (String command : commands) {
            if (command.contains("forward")) {
                int value = Integer.valueOf(command.substring(command.indexOf(' ') + 1));
                horizontalPosition += value;
                depth += value * aim;
            } else if (command.contains("down")) {
                aim += Integer.valueOf(command.substring(command.indexOf(' ') + 1));
            } else {
                aim -= Integer.valueOf(command.substring(command.indexOf(' ') + 1));
            }
        }
        return horizontalPosition * depth;
    }
}
