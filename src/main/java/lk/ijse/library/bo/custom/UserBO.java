package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.UserDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserBO {
    public boolean UserAdd(UserDTO user) throws SQLException, ClassNotFoundException;
    public User UsersearchFrom(String id) throws SQLException, ClassNotFoundException;

}
