package Lab3.Ex3_Hotel;

public class Guest extends Person {
    private String citizenId;

    public Guest(String name, int age, String citizenId) {
        super(name, age);
        setCitizenId(citizenId);
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        if (citizenId == null || citizenId.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid citizen ID!");
        }
        this.citizenId = citizenId.trim();
    }

    public String getID() {
        return citizenId;
    }

    public void setID(String id) {
        setCitizenId(id);
    }

    @Override
    public String toString() {
        return String.format("[Guest] %s | Citizen ID (CCCD): %s",
                super.toString(), citizenId);
    }
}
