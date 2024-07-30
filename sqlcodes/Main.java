package sqlcodes;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DatabaseConnection.getConnection();
            BookDAO bookDAO = new BookDAOImpl(connection);

            for (int i = 0; i < 2; i++) {
                System.out.println("Enter book details:");
                System.out.print("Book name: ");
                String bookName = scanner.nextLine();
                System.out.print("Release date (YYYY-MM-DD): ");
                String releaseDateStr = scanner.nextLine();
                System.out.print("Author ID: ");
                int authorId = Integer.parseInt(scanner.nextLine());

                Book book = new Book();
                book.setBookName(bookName);
                book.setBookReleaseDate(LocalDate.parse(releaseDateStr));
                book.setAuthorId(authorId);

                bookDAO.insertBook(book);
                System.out.println("Book inserted successfully.");
            }
            System.out.print("Enter book name to search: ");
            String searchBookName = scanner.nextLine();

            List<Book> foundBooks = bookDAO.searchBooksByName(searchBookName);

            if (foundBooks.isEmpty()) {
                System.out.println("No books found matching the given name.");
            } else {
                System.out.println("Found books:");
                for (Book book : foundBooks) {
                    System.out.println("Book ID: " + book.getBookId());
                    System.out.println("Book Name: " + book.getBookName());
                    System.out.println("Release Date: " + book.getBookReleaseDate());
                    System.out.println("Author ID: " + book.getAuthorId());
                    System.out.println("Author Name: " + book.getAuthorName());
                    System.out.println("--------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
