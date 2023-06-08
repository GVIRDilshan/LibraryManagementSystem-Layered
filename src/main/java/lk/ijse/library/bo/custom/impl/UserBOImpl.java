package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.UserBO;
import lk.ijse.library.dao.custom.impl.UserDAOImpl;
import lk.ijse.library.dto.UserDTO;
import lk.ijse.library.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {

    UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    public boolean UserAdd(UserDTO user) throws SQLException, ClassNotFoundException {
        userDAO.add(new User(user.getUserName(), user.getName(), user.getPassword()));
        return false;
    }

    @Override
    public User UsersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return userDAO.search(id);
    }
}