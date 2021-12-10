package advent_of_code.day_5;

import java.util.ArrayList;
import java.util.List;

public class LinePlotter {
    private VentMap ventMap;

    public LinePlotter(VentMap map) {
        this.ventMap = map;
    }

    public void plotLines(List<String> inputs) {
        List<PlotPoint> points = parseInputs(inputs);
        for (PlotPoint point : points) {
            ventMap.plotPoint(point.getX(), point.getY());
        }
    }

    private List<PlotPoint> parseInputs(List<String> inputs) {
        List<Line> lines = parseLines(inputs);

        List<Line> orientatedLines = lines.stream().map(l -> orientLine(l)).toList();

        List<PlotPoint> plotPoints = new ArrayList<>();
        for (Line line : orientatedLines) {
            if (isHorizontal(line)) {
                int startingX = line.getStartingPlot().getX();
                int endingX = line.getEndingPlot().getX();

                for (int i = startingX; i <= endingX; i++) {
                    plotPoints.add(new PlotPoint(i, line.startingPlot.getY()));
                }
            } else if (isVertical(line)) {
                int startingY = line.getStartingPlot().getY();
                int endingY = line.getEndingPlot().getY();

                for (int i = startingY; i <= endingY; i++) {
                    plotPoints.add(new PlotPoint(line.startingPlot.getX(), i));
                }
            } else {
                int startingX = line.getStartingPlot().getX();
                int endingX = line.getEndingPlot().getX();
                int startingY = line.getStartingPlot().getY();
                int endingY = line.getEndingPlot().getY();
                int yCounter = startingY;
                for (int x = startingX; x <= endingX; x++) {
                    plotPoints.add(new PlotPoint(x, yCounter));
                    if (startingY < endingY) yCounter++;
                    else yCounter--;
                }
            }
        }
        return plotPoints;
    }

    private Line orientLine(Line line) {
        if (line.startingPlot.getX() > line.endingPlot.getX() ||
                isVertical(line) && line.startingPlot.getY() > line.endingPlot.getY())
            return new Line(line.endingPlot, line.startingPlot);
        return line;
    }

    private boolean isVertical(Line line) {
        return line.startingPlot.getX() == line.endingPlot.getX();
    }

    private boolean isHorizontal(Line line) {
        return line.startingPlot.getY() == line.endingPlot.getY();
    }

    private List<Line> parseLines(List<String> lineInputs) {
        List<Line> lines = new ArrayList<>();
        for (String lineInput : lineInputs) { //"1,2 -> 3,4"
            String[] coordinates = lineInput.split(" -> ");//["1,2","3,4"]

            String[] startingCoordinates = coordinates[0].split(",");
            String[] endingCoordinates = coordinates[1].split(",");

            lines.add(new Line(startingCoordinates, endingCoordinates));
        }
        return lines;
    }


    public class PlotPoint {

        private final int x;
        private final int y;

        public PlotPoint(int x, int y) {

            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "PlotPoint{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private class Line {
        PlotPoint startingPlot;
        PlotPoint endingPlot;

        public Line(String[] startingCoordinates, String[] endingCoordinates) {
            startingPlot = new PlotPoint(Integer.parseInt(startingCoordinates[0]),
                    Integer.parseInt(startingCoordinates[1]));
            endingPlot = new PlotPoint(Integer.parseInt(endingCoordinates[0]),
                    Integer.parseInt(endingCoordinates[1]));
        }

        public Line(PlotPoint startingPlot, PlotPoint endingPlot) {
            this.startingPlot = startingPlot;
            this.endingPlot = endingPlot;
        }

        public PlotPoint getStartingPlot() {
            return startingPlot;
        }

        public PlotPoint getEndingPlot() {
            return endingPlot;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "startingPlot=" + startingPlot +
                    ", endingPlot=" + endingPlot +
                    '}';
        }
    }
}
