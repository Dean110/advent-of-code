package advent_of_code.day_4;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BingoBoard {
    private final List<Spot> spots;

    public BingoBoard(List<Integer> numbers) {
        spots = numbers.stream()
                       .map(number -> new Spot(number))
                       .toList();
    }

    public void markNumber(int number) {
        Optional<Spot> spotCandidate = spots.stream()
                                            .filter(spot -> spot.getNumber() == number)
                                            .findFirst();
        if (spotCandidate.isPresent()) spotCandidate.get()
                                                    .mark();
    }

    public boolean isAWinner() {
        return evaluateRowsForWinner() || evaluateColumnsForWinner();
    }

    private boolean evaluateRowsForWinner() {
        int chunkSize = 5;
        AtomicInteger counter = new AtomicInteger();
        Collection<List<Spot>> rows = spots.stream()
                                           .collect(Collectors.groupingBy(spot -> counter.getAndIncrement() / chunkSize))
                                           .values();
        return rows.stream()
                   .filter(row -> row.stream()
                                     .filter(spot -> !spot.isMarked())
                                     .findFirst()
                                     .isEmpty())
                   .findFirst()
                   .isPresent();
    }

    private boolean evaluateColumnsForWinner() {
        int chunkSize = 5;
        AtomicInteger counter = new AtomicInteger();
        Collection<List<Spot>> columns = spots.stream()
                                              .collect(Collectors.groupingBy(spot -> counter.getAndIncrement() % chunkSize))
                                              .values();
        return columns.stream()
                      .filter(row -> row.stream()
                                        .filter(spot -> !spot.isMarked())
                                        .findFirst()
                                        .isEmpty())
                      .findFirst()
                      .isPresent();
    }

    public List<Spot> getSpots() {
        return spots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BingoBoard that = (BingoBoard) o;
        return Objects.equals(spots, that.spots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spots);
    }

    @Override
    public String toString() {
        return "BingoBoard{" +
                "spots=" + spots +
                '}';
    }

    public class Spot {
        private final int number;
        private boolean marked;

        public Spot(Integer number) {
            this.number = number;
            marked = false;
        }

        public int getNumber() {
            return number;
        }

        public boolean isMarked() {
            return marked;
        }

        public void mark() {
            marked = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Spot spot = (Spot) o;
            return number == spot.number && marked == spot.marked;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number, marked);
        }

        @Override
        public String toString() {
            return "Spot{" +
                    "number=" + number +
                    ", marked=" + marked +
                    '}';
        }
    }
}
