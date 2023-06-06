package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.BookDTO;

import java.sql.*;
import java.util.ArrayList;

public class BookModel {

    public static boolean BookAdd(BookDTO book) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into book values(?,?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, book.getId());
        stm.setObject(2, book.getName());
        stm.setObject(3, book.getAuthor());
        stm.setObject(4, book.getPublisher());
        stm.setObject(5, book.getSupplier());
        stm.setObject(6, book.getQty());


        return stm.executeUpdate() > 0;
    }
    public static ArrayList<BookDTO> loadAllBooks() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from book";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<BookDTO> books = new ArrayList<>();

        while (result.next()) {
            BookDTO book = new BookDTO();
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

    public static ArrayList<String> loadAllBookIds() throws SQLException {

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

    public static BookDTO searchFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from book where bookId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            BookDTO book = new BookDTO();

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

    public static boolean deleteFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from book where BookId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static Boolean updateBook(BookDTO book) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update book set name=?,author_Id=?" +
                ",Publisher=?,Supplier=?," +
                "qty=? where bookId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,book.getName());
        stm.setObject(2,book.getAuthor());
        stm.setObject(3,book.getPublisher());
        stm.setObject(4,book.getSupplier());
        stm.setObject(5,book.getQty());
        stm.setObject(6,book.getId());

        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }
//    public static String genarateTurnId() throws SQLException {
//        Connection con = DBConnection.getInstance().getConnection();
//
//        PreparedStatement ps = con.prepareStatement("SELECT memberId FROM member ORDER BY memberId DESC LIMIT 1 ");
//
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()){
//            String lastBookId = rs.getString(1);
//
//            String[] temp = lastBookId.split("B");
//
//            int value = Integer.parseInt((temp[1));
//            String nextValue = (value+1) + "";
//
//            if (nextValue.length() == 1 ){
//                return "B00"+ nextValue;
//            }else if (nextValue.length() == 2 ){
//                return "B0" + nextValue;
//            }else {
//                return "B";
//            }
//
//
//        }
//        return "B001";
//    }
}

