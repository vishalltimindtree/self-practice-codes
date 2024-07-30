package sqlcodes;

import java.util.List;

public interface BookDAO {
    void insertBook(Book book);
    List<Book> searchBooksByName(String bookName);
}
