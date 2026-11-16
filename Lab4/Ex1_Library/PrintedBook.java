package Lab4.Ex1_Library;

public class PrintedBook extends LibraryItem {
    private int numpage;

    public PrintedBook(String ID, String title, String author, int day, int num){
        super(ID, title, author, day);
        setNumpage(num);
    }

    public int getNumpage(){
        return numpage;
    }

    public void setNumpage(int page){
        if (page <= 0){
            throw new IllegalArgumentException("Invalid num of page!");
        }

        this.numpage = page;
    }

    @Override
    public int calculateFee(){
        return 5000 * super.getBorrowday() + 10 * numpage;
    }

    @Override
    public String displayInfo(){
        return this.toString();
    }

    @Override
    public String toString(){
        return String.format("[Printed Book] %s | Num of page: %d",
                            super.toString(), numpage);
    }
}
