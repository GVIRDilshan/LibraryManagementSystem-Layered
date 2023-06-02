package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.ExibitionDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExibitionModel {
    public static boolean SaveExibition(ExibitionDTO exibition) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into exibitions values(?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,exibition.getExibitionId());
        stm.setObject(2,exibition.getExibitionDate());
        stm.setObject(3,exibition.getExibitionTime());
        stm.setObject(4,exibition.getExibitionDesc());

        return stm.executeUpdate() > 0;
    }
    
    public static ArrayList<String> loadAllExibitionIds() throws SQLException {

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
    
    public static ExibitionDTO searchFrom(String id) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from exibitions where ExibitionsId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            ExibitionDTO exibition = new ExibitionDTO();
            exibition.setExibitionId(result.getString(1));
            exibition.setExibitionDate(result.getString(2));
            exibition.setExibitionTime(result.getString(3));
            exibition.setExibitionDesc(result.getString(4));
            return exibition;
        }
        return null;
    }
}
