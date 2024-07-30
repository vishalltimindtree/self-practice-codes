package sqlcodes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private Connection connection;

    public BookDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertBook(Book book) {
        String sql = "INSERT INTO Book (bookName, bookReleaseDate, authorId) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, book.getBookName());
            pstmt.setDate(2, Date.valueOf(book.getBookReleaseDate()));
            pstmt.setInt(3, book.getAuthorId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> searchBooksByName(String bookName) {
        List<Book> books = new ArrayList<Book>();
        String sql = "SELECT b.*, a.authorName FROM Book b JOIN Author a ON b.authorId = a.authorId WHERE b.bookName LIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + bookName + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setBookId(rs.getInt("bookId"));
                    book.setBookName(rs.getString("bookName"));
                    book.setBookReleaseDate(rs.getDate("bookReleaseDate").toLocalDate());
                    book.setAuthorId(rs.getInt("authorId"));
                    book.setAuthorName(rs.getString("authorName"));
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
