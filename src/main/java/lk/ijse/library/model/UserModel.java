package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
//    public static boolean updateUser(User user) throws SQLException {
//        Connection con = DBConnection.getInstance().getConnection();
//        PreparedStatement ps = con.prepareStatement("UPDATE user SET password = ? WHERE userName = ?");
//
//        ps.setString(1 , user.getPassword());
//        ps.setString(2 , user.getUserName());
//
//        return ps.executeUpdate() > 0;
//
//    }

    public static UserDTO SearchUser(String name) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from user where useName = ?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, name);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            UserDTO user = new UserDTO();
            user.setName(result.getString(1));
            user.setUserName(result.getString(2));
            user.setPassword(result.getString(3));
            return user;
        }

        return null;
    }

    public static boolean singUp(UserDTO user) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user(name , useName, password) VALUES(?, ?, ?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,user.getName());
        stm.setObject(2,user.getUserName());
        stm.setObject(3,user.getPassword());

        int result = stm.executeUpdate();
        return result > 0;
    }
}
