package advent_of_code.day_6;

public class Fish {
    private int daysToSpawn;

    public Fish(int daysToSpawn) {

        this.daysToSpawn = daysToSpawn;
    }

    public int getDaysToSpawn() {
        return daysToSpawn;
    }

    public void ageFish() {
        daysToSpawn--;
    }

    public void resetSpawnCounter() {
        daysToSpawn = 6;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "daysToSpawn =" + daysToSpawn +
                '}';
    }
}
