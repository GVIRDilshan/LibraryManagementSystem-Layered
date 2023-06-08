package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.BookBO;
import lk.ijse.library.dao.custom.impl.BookDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookBOImpl implements BookBO {
    BookDAOImpl bookDAO = new BookDAOImpl();
    @Override
    public boolean BookAdd(BookDTO book) throws SQLException, ClassNotFoundException {
        bookDAO.add(new Book(book.getId(),book.getName(),book.getAuthor(),book.getPublisher(),book.getSupplier(),book.getQty()));
        return false;
    }

    @Override
    public Book BooksearchFrom(String id) throws SQLException, ClassNotFoundException {
        return bookDAO.search(id);
    }

    @Override
    public boolean BookDelete(String id) throws SQLException, ClassNotFoundException {
        return bookDAO.delete(id);
    }

    @Override
    public boolean BookUpdate(BookDTO book) throws SQLException, ClassNotFoundException {
        bookDAO.update(new Book(book.getId(),book.getName(),book.getAuthor(),book.getPublisher(),book.getSupplier(),book.getQty()));
        return false;
    }

    @Override
    public String BookGenarateTurnId() throws SQLException, ClassNotFoundException {
        return bookDAO.generateNewID();
    }

    @Override
    public ArrayList<BookDTO> loadAllBookIds() throws SQLException, ClassNotFoundException {
        ArrayList<BookDTO> allBooks = new ArrayList<>();
        ArrayList<String> all = new BookBOImpl().bookDAO.loadAllIds();
        for (String b :  all) {
            allBooks.add(new BookDTO());
        }
        return allBooks;
    }

    @Override
    public ArrayList<BookDTO> loadAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<BookDTO> allBooks = new ArrayList<>();
        ArrayList<Book> all = new BookBOImpl().bookDAO.loadAll();
        for (Book b :  all) {
            allBooks.add(new BookDTO());
        }
        return allBooks;
    }
}
