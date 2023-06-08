package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookBO {
    public boolean BookAdd(BookDTO book) throws SQLException, ClassNotFoundException;
    public Book BooksearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean BookDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean BookUpdate(BookDTO book) throws SQLException, ClassNotFoundException;
    public String BookGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllBookIds() throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllBooks() throws SQLException, ClassNotFoundException;
}
