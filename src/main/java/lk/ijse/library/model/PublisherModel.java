package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.PublisherDTO;

import java.sql.*;
import java.util.ArrayList;

public class PublisherModel {
    public static boolean PublisherAdd(PublisherDTO publisher) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into publisher values(?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);


        stm.setObject(1,publisher.getPublisherID());
        stm.setObject(2,publisher.getPublisherName());
        stm.setObject(3,publisher.getBookID());
        stm.setObject(4,publisher.getPublishDate());

        return stm.executeUpdate() > 0;
    }
    public static PublisherDTO searchFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from publisher where pbId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            PublisherDTO publisher = new PublisherDTO();
            publisher.setPublisherID(result.getString(1));
            publisher.setPublisherName(result.getString(2));
            publisher.setBookID(result.getString(3));
            return publisher;
        }
        return null;
    }
    public static Boolean updatePublisher(PublisherDTO publisher) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update publisher set name=?,Book_Id=?,pdDate=? where pbId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,publisher.getPublisherName());
        stm.setObject(2,publisher.getBookID());
        stm.setObject(3,publisher.getPublisherID());


        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }
    public static boolean deleteFrom(String id) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from publisher where pbId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static ArrayList<String> loadAllPublisherIds() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select pbId from publisher";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> PublisherIds = new ArrayList<>();

        while (result.next()) {
            PublisherIds.add(result.getString(1));
        }
        return PublisherIds;
    }
    public static ArrayList<PublisherDTO> loadAllPublisher() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from publisher";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<PublisherDTO> publishers = new ArrayList<>();

        while (result.next()) {
            PublisherDTO publisher = new PublisherDTO();
            publisher.setPublisherID(result.getString(1));
            publisher.setPublisherName(result.getString(2));
            publisher.setBookID(result.getString(3));
            publisher.setPublishDate(result.getString(4));
            publishers.add(publisher);
        }
        return publishers;
    }
}
