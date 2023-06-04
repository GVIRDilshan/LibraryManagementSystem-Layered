package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.SQLUtil;
import lk.ijse.library.dao.custom.AutorDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public boolean update(AutorDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public AutorDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}