package Lab3.Ex2_Ticket;

public class Full extends Ticket {
    private int price;

    public Full(String ticketId, String holderName, int birthYear){
        super(ticketId, holderName, birthYear, 30);
        price = this.getPrice();
    }

    @Override 
    public int getPrice(){
        return 200000;
    }

    @Override 
    public String toString(){
        return String.format("[Full] %s | Price: %d", 
                            super.toString(), price);
    }
}
