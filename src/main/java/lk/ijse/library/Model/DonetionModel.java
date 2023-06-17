package lk.ijse.library.Model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.DonetionDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonetionModel {

    public static boolean DonetionAdd(DonetionDTO donetion) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into donetion values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,donetion.getDonetionId());
        stm.setObject(2,donetion.getAmmount());
        stm.setObject(3,donetion.getReview());
        stm.setObject(4,donetion.getDonetionName());
        stm.setObject(5,donetion.getExibitionId());

        return stm.executeUpdate() > 0;

    }
}
