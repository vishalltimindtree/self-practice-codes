package sqlcodes;

import java.time.LocalDate;

public class Book {
    private int bookId;
    private String bookName;
    private LocalDate bookReleaseDate;
    private int authorId;
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDate getBookReleaseDate() {
        return bookReleaseDate;
    }

    public void setBookReleaseDate(LocalDate bookReleaseDate) {
        this.bookReleaseDate = bookReleaseDate;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
