package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dao.custom.DonetionDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.entity.Donetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DonetionDAOImpl implements DonetionDAO {
    @Override
    public boolean add(Donetion dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into donetion values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getDonetionId());
        stm.setObject(2,dto.getAmmount());
        stm.setObject(3,dto.getReview());
        stm.setObject(4,dto.getDonetionName());
        stm.setObject(5,dto.getExibitionId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Donetion dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Donetion search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Donetion> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
