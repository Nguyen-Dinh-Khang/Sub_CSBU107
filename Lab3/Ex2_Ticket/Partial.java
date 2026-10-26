package Lab3.Ex2_Ticket;

public class Partial extends Ticket {
    private int price;

    public Partial(String ticketId, String holderName, int birthYear, int gamePlayed){
        super(ticketId, holderName, birthYear, gamePlayed);
        price = this.getPrice();
    }

    @Override 
    public int getPrice(){
        return 70000 + (20000 * this.getGameplayed());
    }

    @Override 
    public String toString(){
        return String.format("[Partial] %s | Price: %d", 
                            super.toString(), price);
    }
}
