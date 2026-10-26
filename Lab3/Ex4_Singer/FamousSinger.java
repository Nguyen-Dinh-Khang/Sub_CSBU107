package Lab3.Ex4_Singer;

public class FamousSinger extends Singer {
    private int gameShows;

    public FamousSinger(String fullName, int yearsOfExperience, int albumsSold, int performances, int gameShows) {
        super(fullName, yearsOfExperience, albumsSold, performances);
        setGameShows(gameShows);
    }

    public int getGameShows() {
        return gameShows;
    }

    public void setGameShows(int gameShows) {
        if (gameShows < 0) {
            throw new IllegalArgumentException("Number of game shows cannot be negative!");
        }
        this.gameShows = gameShows;
    }

    @Override
    public long calculateSalary() {
        return 5000000L + 500000L * getYearsOfExperience() + 1200L * getAlbumsSold() 
                + 500000L * getPerformances() + 500000L * gameShows;
    }

    @Override
    public String toString() {
        return String.format("[Famous Singer] %s | Game shows: %d", super.toString(), gameShows);
    }
}
