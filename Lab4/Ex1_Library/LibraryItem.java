package Lab4.Ex1_Library;

import java.util.HashSet;
import java.util.Set;

abstract class LibraryItem {
    private static final Set<String> IDS = new HashSet<>();

    private String ID;
    private String title;
    private String author;
    private int borrowed_days;

    public LibraryItem(String ID, String title, String author, int days){
        setID(ID);
        setTitle(title);
        setAuthor(author);
        setBorrowday(days);
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        if (ID == null || ID.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid ID!");
        } else if (IDS.contains(ID)){
            throw new IllegalArgumentException("ID is already exist!");
        }

        this.ID = ID;
        IDS.add(ID);
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if (title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid title!");
        }

        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        if (author == null || author.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid author!");
        }

        this.author = author;
    }

    public int getBorrowday(){
        return borrowed_days;
    }

    public void setBorrowday(int days){
        if (days <= 0){
            throw new IllegalArgumentException("Invalid borrowed day!");
        }

        this.borrowed_days = days;
    }

    public abstract int calculateFee();
    public abstract String displayInfo();

    @Override
    public String toString(){
        return String.format("ID: %s | Title: %s | Author: %s | Borrowed day: %d",
                            ID, title, author, borrowed_days);
    }
}
