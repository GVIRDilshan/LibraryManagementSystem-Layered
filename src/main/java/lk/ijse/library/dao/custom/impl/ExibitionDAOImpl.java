package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.ExibitionDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.ExibitionDTO;
import lk.ijse.library.entity.Exibition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExibitionDAOImpl implements ExibitionDAO{
    @Override
    public boolean add(Exibition dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into exibitions values(?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getExibitionId());
        stm.setObject(2,dto.getExibitionDate());
        stm.setObject(3,dto.getExibitionTime());
        stm.setObject(4,dto.getExibitionDesc());

        return stm.executeUpdate() > 0;
    }

    @Override
    public Exibition search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from exibitions where ExibitionsId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Exibition exibition = new Exibition();
            exibition.setExibitionId(result.getString(1));
            exibition.setExibitionDate(result.getString(2));
            exibition.setExibitionTime(result.getString(3));
            exibition.setExibitionDesc(result.getString(4));
            return exibition;
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select ExibitionsId from exibitions";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> ExibitionIds = new ArrayList<>();

        while (result.next()) {
            ExibitionIds.add(result.getString(1));
        }
        return ExibitionIds;
    }

    @Override
    public boolean update(Exibition dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Exibition> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
