package Lab3.Ex4_Singer;

public class RegularSinger extends Singer {
    public RegularSinger(String fullName, int yearsOfExperience, int albumsSold, int performances) {
        super(fullName, yearsOfExperience, albumsSold, performances);
    }

    @Override
    public long calculateSalary() {
        return 3000000L + 500000L * getYearsOfExperience() + 1000L * getAlbumsSold() + 200000L * getPerformances();
    }

    @Override
    public String toString() {
        return "[Regular Singer] " + super.toString();
    }
}
