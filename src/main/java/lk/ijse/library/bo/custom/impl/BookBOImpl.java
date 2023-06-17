package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.BookBO;
import lk.ijse.library.dao.custom.impl.BookDAOImpl;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Autor;
import lk.ijse.library.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public class BookBOImpl implements BookBO {
    BookDAOImpl bookDAO = new BookDAOImpl();
    @Override
    public boolean bookAdd(BookDTO book) throws SQLException, ClassNotFoundException {
        return bookDAO.add(new Book(book.getId(),book.getName(),book.getAuthor(),book.getPublisher(),book.getSupplier(),book.getQty()));
    }

    @Override
    public BookDTO booksearchFrom(String id) throws SQLException, ClassNotFoundException {
        Book book = bookDAO.search(id);
        return new BookDTO(book.getId(),book.getName(),book.getAuthor(),book.getPublisher(),book.getSupplier(),book.getQty());
    }

    @Override
    public boolean bookDelete(String id) throws SQLException, ClassNotFoundException {
        return bookDAO.delete(id);
    }

    @Override
    public boolean bookUpdate(BookDTO book) throws SQLException, ClassNotFoundException {
        bookDAO.update(new Book(book.getId(),book.getName(),book.getAuthor(),book.getPublisher(),book.getSupplier(),book.getQty()));
        return false;
    }

    @Override
    public String bookGenarateTurnId() throws SQLException, ClassNotFoundException {
        return bookDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllBookIds() throws SQLException, ClassNotFoundException {
        return bookDAO.loadAllIds();
    }

    @Override
    public ArrayList<BookDTO> loadAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<BookDTO> allBooks = new ArrayList<>();
        for (Book b : bookDAO.loadAll()) {
            allBooks.add(new BookDTO(b.getId(),b.getName(),b.getAuthor(),b.getPublisher(),b.getSupplier(),b.getQty()));
        }
        return allBooks;
    }
}
