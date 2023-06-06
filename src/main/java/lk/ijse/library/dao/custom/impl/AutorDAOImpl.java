package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.SQLUtil;
import lk.ijse.library.dao.custom.AutorDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public boolean add(Autor dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into autor values(?,?,?,?)";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setObject(1,dto.getAutorID());
        pstm.setObject(2,dto.getAutorName());
        pstm.setObject(3,dto.getBookName());
        pstm.setObject(4,dto.getBookID());

        return pstm.executeUpdate() > 0;
    }
    @Override
    public Autor search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from autor where AutorId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, id + "");
        ResultSet rst = stm.executeQuery();
        rst.next();
       // return new Autor(id + "", rst.getString("AutorId"), rst.getString("name"));
        return null;
    }

    @Override
    public boolean update(Autor dto) throws SQLException, ClassNotFoundException {
       Connection con = DBConnection.getInstance().getConnection();

        String sql = "update autor set name=?, BookName=?,Book_Id=? where AutorId=?";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setObject(1,dto.getAutorName());
        pstm.setObject(2,dto.getBookName());
        pstm.setObject(3,dto.getBookID());
        pstm.setObject(4,dto.getAutorID());

        return pstm.executeUpdate() > 0;
    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "delete from autor where AutorId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        return stm.executeUpdate() > 0;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT autorId FROM autor ORDER BY autorId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastAutorId = rs.getString(1);

            String[] temp = lastAutorId.split("A");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "A00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "A0" + nextValue;
            }else {
                return "A";
            }


        }
        return  "A001";
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select  AutorId from Autor";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> AutorIds = new ArrayList<>();

        while (result.next()) {
            AutorIds.add(result.getString(1));
        }
        return AutorIds;
    }

    @Override
    public ArrayList<Autor> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from autor";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Autor> autors = new ArrayList<>();

        while (result.next()) {
            Autor autor = new Autor();
            autor.setAutorID(result.getString(1));
            autor.setAutorName(result.getString(2));
            autor.setBookName(result.getString(3));
            autor.setBookID(result.getString(4));

            autors.add(autor);
        }

        return autors;
    }
}