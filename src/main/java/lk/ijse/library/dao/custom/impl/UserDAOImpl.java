package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.UserDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.UserDTO;
import lk.ijse.library.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user(name , useName, password) VALUES(?, ?, ?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getName());
        stm.setObject(2,dto.getUserName());
        stm.setObject(3,dto.getPassword());

        int result = stm.executeUpdate();
        return result > 0;
    }

    @Override
    public User search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from user where useName = ?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            User user = new User();
            user.setName(result.getString(1));
            user.setUserName(result.getString(2));
            user.setPassword(result.getString(3));
            return user;
        }

        return null;
    }



    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
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
    public ArrayList<User> loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
