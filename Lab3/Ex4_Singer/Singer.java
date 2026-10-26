package Lab3.Ex4_Singer;

public abstract class Singer {
    private String fullName;
    private int yearsOfExperience;
    private int albumsSold;
    private int performances;

    public Singer(String fullName, int yearsOfExperience, int albumsSold, int performances) {
        setFullName(fullName);
        setYearsOfExperience(yearsOfExperience);
        setAlbumsSold(albumsSold);
        setPerformances(performances);
    }

    public abstract long calculateSalary();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid full name!");
        }
        this.fullName = fullName.trim();
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Years of experience cannot be negative!");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getAlbumsSold() {
        return albumsSold;
    }

    public void setAlbumsSold(int albumsSold) {
        if (albumsSold < 0) {
            throw new IllegalArgumentException("Number of albums sold cannot be negative!");
        }
        this.albumsSold = albumsSold;
    }

    public int getPerformances() {
        return performances;
    }

    public void setPerformances(int performances) {
        if (performances < 0) {
            throw new IllegalArgumentException("Number of performances cannot be negative!");
        }
        this.performances = performances;
    }

    @Override
    public String toString() {
        return String.format("Name: %s | Experience: %d yrs | Albums: %d | Shows: %d | Salary: %,d VND",
                fullName, yearsOfExperience, albumsSold, performances, calculateSalary());
    }
}
