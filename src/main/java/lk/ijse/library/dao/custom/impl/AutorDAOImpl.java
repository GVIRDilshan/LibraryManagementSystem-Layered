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
    public ArrayList<AutorDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(AutorDTO dto) throws SQLException, ClassNotFoundException {
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
    public AutorDTO search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from autor where AutorId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setString(1, id + "");
        ResultSet rst = stm.executeQuery();
        rst.next();
        return new AutorDTO(id + "", rst.getString("AutorId"), rst.getString("name"));
    }
       /* stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            AutorDTO autor = new AutorDTO();
            autor.setAutorID(result.getString(1));
            autor.setAutorName(result.getString(2));
            autor.setBookID(result.getString(3));
            autor.setBookName(result.getString(4));

            return autor;
        }
        return null;*/
    @Override
    public boolean update(AutorDTO dto) throws SQLException, ClassNotFoundException {
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
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }


}