package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BookBO extends SuperBO {
    public boolean bookAdd(BookDTO book) throws SQLException, ClassNotFoundException;
    public Book booksearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean bookDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean bookUpdate(BookDTO book) throws SQLException, ClassNotFoundException;
    public String bookGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllBookIds() throws SQLException, ClassNotFoundException;
    public ArrayList<BookDTO> loadAllBooks() throws SQLException, ClassNotFoundException;
}
