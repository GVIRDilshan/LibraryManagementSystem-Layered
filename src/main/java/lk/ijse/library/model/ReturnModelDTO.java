package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.Return;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnModelDTO {

    public static boolean ReturnSet(Return returns, String Qty, String BookId, String IssuseID) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into returnse values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        con.setAutoCommit(false);

        stm.setObject(1, returns.getReturnId());
        stm.setObject(2, returns.getReturnDate());
        stm.setObject(3, returns.getIssuseId());
        stm.setObject(4, returns.getIssuseDate());
        stm.setObject(5, returns.getBookId());

        int TakeIt = stm.executeUpdate();

        if (TakeIt > 0) {
            String sql2 = "update book set qty=qty+? where bookId=?";

            PreparedStatement stm2 = con.prepareStatement(sql2);

            stm2.setObject(1, Qty);
            stm2.setObject(2, BookId);

            int itemUpdate = stm2.executeUpdate();

            if (itemUpdate > 0) {
                con.commit();
                con.setAutoCommit(true);
                return true;
            }
        }
        if (TakeIt > 0) {

            String sql3 = "DELETE FROM issuse WHERE iid=?";

            PreparedStatement stm3 = con.prepareStatement(sql3);

            stm3.setObject(1,IssuseID);

            int itemUpdate1 = stm3.executeUpdate();

            if (itemUpdate1 > 0) {
                con.commit();
                con.setAutoCommit(true);
                return true;
            }
        }
        con.rollback();
        con.setAutoCommit(true);
        con.rollback();
        con.setAutoCommit(true);

        return false;
    }
    public static ArrayList<Return> loadAllReturnas() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from returnse";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Return> returns = new ArrayList<>();

        while (result.next()) {
            Return returnss = new Return();
            returnss.setReturnId(result.getString(1));
            returnss.setReturnDate(result.getString(2));
            returnss.setIssuseId(result.getString(3));
            returnss.setIssuseDate(result.getString(4));
            returnss.setBookId(result.getString(5));

            returns.add(returnss);
        }

        return returns;
    }
}

