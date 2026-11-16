package Lab4.Ex1_Library;

public class Magazine extends LibraryItem{
    private int numissue;

    public Magazine(String ID, String title, String author, int day, int num){
        super(ID, title, author, day);
        setNumissue(num);
    }

    public int getNumissue(){
        return numissue;
    }

    public void setNumissue(int num){
        if (num <= 0){
            throw new IllegalArgumentException("Invalid issue number!");
        }

        this.numissue = num;
    }

    @Override
    public int calculateFee(){
        return 3000 * super.getBorrowday() + 2000;
    }

    @Override
    public String displayInfo(){
        return this.toString();
    }

    @Override
    public String toString(){
        return String.format("[Magazine] %s | Issue number: %d",
                            super.toString(), numissue);
    }
}
