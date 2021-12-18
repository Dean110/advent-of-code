package advent_of_code.day_2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationPlotterTest {
    @Test
    public void givenForward1Down1Returns1() {
        List<String> commands = List.of("forward 1", "down 1");
        NavigationPlotter underTest = new NavigationPlotter();
        int result = underTest.computeCommands(commands);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void givenForward2Down1Returns3() {
        List<String> commands = List.of("forward 2", "down 1", "forward 1");
        NavigationPlotter underTest = new NavigationPlotter();
        int result = underTest.computeCommands(commands);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void givenForward4Down4Up2Forward1Forward1Returns10() {
        List<String> commands = List.of("forward 4", "down 4", "up 2", "forward 1", "forward 1");
        NavigationPlotter underTest = new NavigationPlotter();
        int result = underTest.computeCommands(commands);
        assertThat(result).isEqualTo(24);
    }
}
