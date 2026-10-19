package Lab2.Author_and_Book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private List<Author> authors;
    private double price;
    private int qty = 0; // quantity

    public Book(String name, List<Author> authors, double price) {
        this.name = name;
        this.authors = (authors != null) ? new ArrayList<>(authors) : new ArrayList<>();
        this.price = price;
    }

    public Book(String name, List<Author> authors, double price, int qty) {
        this(name, authors, price);
        this.qty = qty;
    }

    public Book(String name, Author singleAuthor, double price, int qty) {
        this.name = name;
        this.authors = new ArrayList<>();
        if (singleAuthor != null) {
            this.authors.add(singleAuthor);
        }
        this.price = price;
        this.qty = qty;
    }

    public void addAuthor(Author author) {
        if (author != null) {
            this.authors.add(author);
        }
    }

    public String getAuthorNames() {
        if (authors.isEmpty()) return "Unknown author";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            sb.append(authors.get(i).getName());
            if (i < authors.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public String getName() { return name; }
    public List<Author> getAuthors() { return authors; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    @Override
    public String toString() {
        return "Book[name=" + name + ", authors=" + authors + ", price=" + price + ", qty=" + qty + "]";
    }
}