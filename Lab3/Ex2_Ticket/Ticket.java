package Lab3.Ex2_Ticket;

public abstract class Ticket {
    private String ticketId;
    private String holderName;
    private int birthYear;
    private int gamesPlayed;

    public Ticket(String ticketId, String holderName, int birthYear, int gamesPlayed) {
        setTicketid(ticketId);
        setHoldername(holderName);
        setBirth(birthYear);
        setGameplayed(gamesPlayed);
    }    

    public String getTicketid(){
        return ticketId;
    }

    public void setTicketid(String id){
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to input id");
        }
        this.ticketId = id.trim();
    }

    public String getHoldername(){
        return holderName;
    }

    public void setHoldername(String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("You have to input holder's name");
        }
        this.holderName = name.trim();
    }

    public int getBirth(){
        return birthYear;
    }

    public void setBirth(int birth){
        if (birth <= 0){
            throw new IllegalArgumentException("The year of birth has to over 0!");
        }
        this.birthYear = birth;
    }

    public int getGameplayed(){
        return gamesPlayed;
    }

    public void setGameplayed(int played){
        if (played < 0){
            throw new IllegalArgumentException("The number of game played cannot be negative!");
        }
        this.gamesPlayed = played;
    }

    public abstract int getPrice();

    @Override
    public String toString(){
        return String.format("Id: %s | Holder's name: %s | Year of birth: %d | Game: %d", 
                            ticketId, holderName, birthYear, gamesPlayed);
    }
}
