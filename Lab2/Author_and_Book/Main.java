package Lab2.Author_and_Book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo các đối tượng tác giả
        Author author1 = new Author("Robert C. Martin", "unclebob@cleancoder.com", 'm');
        Author author2 = new Author("Martin Fowler", "fowler@thoughtworks.com", 'm');

        // 2. Tạo sách sử dụng Constructor 1 tác giả (tiện lợi)
        Book singleAuthorBook = new Book("Clean Code", author1, 35.50, 100);
        System.out.println("--- Book with 1 author ---");
        System.out.println("Book's name: " + singleAuthorBook.getName());
        System.out.println("Author: " + singleAuthorBook.getAuthorNames());
        System.out.println("Detail: " + singleAuthorBook);

        // 3. Tạo sách sử dụng Constructor danh sách nhiều tác giả
        List<Author> multiAuthors = new ArrayList<>();
        multiAuthors.add(author1);
        multiAuthors.add(author2);

        Book multiAuthorBook = new Book("Agile Principles & Patterns", multiAuthors, 45.00, 50);
        System.out.println("\n--- Book with many authors ---");
        System.out.println("Book's name: " + multiAuthorBook.getName());
        System.out.println("Authors: " + multiAuthorBook.getAuthorNames());
        System.out.println("Detail: " + multiAuthorBook);
    }
}
