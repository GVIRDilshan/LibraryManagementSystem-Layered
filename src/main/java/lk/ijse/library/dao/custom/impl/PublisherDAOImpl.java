package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.bo.custom.PublisherBO;
import lk.ijse.library.dao.custom.PublisherDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.PublisherDTO;
import lk.ijse.library.entity.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherDAOImpl implements PublisherDAO {
    @Override
    public boolean add(Publisher dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into publisher values(?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getPublisherID());
        stm.setObject(2,dto.getPublisherName());
        stm.setObject(3,dto.getBookID());
        stm.setObject(4,dto.getPublishDate());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Publisher dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update publisher set name=?,Book_Id=?,pdDate=? where pbId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getPublisherName());
        stm.setObject(2,dto.getBookID());
        stm.setObject(3,dto.getPublisherID());

        return stm.executeUpdate() > 0;

    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from publisher where pbId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public Publisher search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from publisher where pbId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Publisher publisher = new Publisher();
            publisher.setPublisherID(result.getString(1));
            publisher.setPublisherName(result.getString(2));
            publisher.setBookID(result.getString(3));
            return publisher;
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
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

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT pbId FROM publisher ORDER BY pbId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastAutorId = rs.getString(1);

            String[] temp = lastAutorId.split("A");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "P00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "P0" + nextValue;
            }else {
                return "P";
            }


        }
        return  "P001";
    }

    @Override
    public ArrayList<Publisher> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from publisher";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Publisher> publishers = new ArrayList<>();

        while (result.next()) {
            Publisher publisher = new Publisher();
            publisher.setPublisherID(result.getString(1));
            publisher.setPublisherName(result.getString(2));
            publisher.setBookID(result.getString(3));
            publisher.setPublishDate(result.getString(4));
            publishers.add(publisher);
        }
        return publishers;
    }
}
