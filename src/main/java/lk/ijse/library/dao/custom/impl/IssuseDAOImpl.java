package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.entity.Issuse;

import java.sql.SQLException;
import java.util.ArrayList;

public class IssuseDAOImpl implements CrudDAO<Issuse> {
    @Override
    public boolean add(Issuse dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Issuse dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Issuse search(String id) throws SQLException, ClassNotFoundException {
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
    public ArrayList<Issuse> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
