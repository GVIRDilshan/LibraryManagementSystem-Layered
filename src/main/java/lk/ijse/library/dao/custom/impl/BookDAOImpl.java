package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.BookDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    @Override
    public boolean add(Book dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into book values(?,?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, dto.getId());
        stm.setObject(2, dto.getName());
        stm.setObject(3, dto.getAuthor());
        stm.setObject(4, dto.getPublisher());
        stm.setObject(5, dto.getSupplier());
        stm.setObject(6, dto.getQty());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Book dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update book set name=?,author_Id=?" +
                ",Publisher=?,Supplier=?," +
                "qty=? where bookId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getName());
        stm.setObject(2,dto.getAuthor());
        stm.setObject(3,dto.getPublisher());
        stm.setObject(4,dto.getSupplier());
        stm.setObject(5,dto.getQty());
        stm.setObject(6,dto.getId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from book where BookId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public Book search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from book where bookId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Book book = new Book();

            book.setId(result.getString(1));
            book.setName(result.getString(2));
            book.setAuthor(result.getString(3));
            book.setPublisher(result.getString(4));
            book.setSupplier(result.getString(5));
            book.setQty(Integer.parseInt(result.getString(6)));

            return book;
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select bookId from book";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> BookIds = new ArrayList<>();

        while (result.next()) {
            BookIds.add(result.getString(1));
        }
        return BookIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT bookId FROM book ORDER BY bookId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastBookId = rs.getString(1);

            String[] temp = lastBookId.split("B");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "B00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "B0" + nextValue;
            }else {
                return "B";
            }
        }
        return "B001";
    }

    @Override
    public ArrayList<Book> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from book";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Book> books = new ArrayList<>();

        while (result.next()) {
            Book book = new Book();
            book.setId(result.getString(1));
            book.setName(result.getString(2));
            book.setAuthor(result.getString(3));
            book.setPublisher(result.getString(4));
            book.setSupplier(result.getString(5));
            book.setQty(Integer.parseInt(result.getString(6)));

            books.add(book);
        }

        return books;
    }
}
