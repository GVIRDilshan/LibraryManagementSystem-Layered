package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.Issuse;

import java.sql.*;
import java.util.ArrayList;

public class IssuseModelDTO {
    public static boolean issuseFrom(Issuse issuse, String qty, String Bookd) throws SQLException {

        DBConnection.getInstance().getConnection().setAutoCommit(false);

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into issuse values(?,?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,issuse.getIssusId());
        stm.setObject(2,issuse.getBookId());
        stm.setObject(3,issuse.getIssusDate());
        stm.setObject(4,issuse.getMemberId());
        stm.setObject(5,issuse.getDueDate());
        stm.setObject(6,issuse.getIssuseQty());

        int TakeIt = stm.executeUpdate();

        if (TakeIt>0){
            String sql2 = "update book set qty=qty-? where bookId=?";

            PreparedStatement stm2 = con.prepareStatement(sql2);

            stm2.setObject(1,qty);
            stm2.setObject(2,Bookd);

            int itemUpdate = stm2.executeUpdate();

            if(itemUpdate>0){
                con.commit();
                con.setAutoCommit(true);
                return true;
            }
            con.rollback();
            con.setAutoCommit(true);
        }
        con.rollback();
        con.setAutoCommit(true);

        return false;
    }
    
    public static Issuse IssuseSearch(String iid) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from issuse where iid = ?";

        PreparedStatement stm = con.prepareStatement(sql);

            stm.setObject(1, iid);

            ResultSet result = stm.executeQuery();

            if (result.next()) {
                Issuse issuses = new Issuse();
                issuses.setIssusId(result.getString(1));
                issuses.setBookId(result.getString(2));
                issuses.setIssusDate(result.getString(3));
                issuses.setMemberId(result.getString(4));
                issuses.setDueDate(result.getString(5));
                issuses.setIssuseQty(result.getString(6));

                return issuses;
            }
            return null;
     }
    
    public static ArrayList<Issuse> loadAllIssuse() throws SQLException {

            Connection con = DBConnection.getInstance().getConnection();
            String sql = "select * from issuse";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet result = stm.executeQuery();

            ArrayList<Issuse> issuses = new ArrayList<>();

            while (result.next()) {
                Issuse issuse1 = new Issuse();

                issuse1.setIssusId(result.getString(1));
                issuse1.setBookId(result.getString(2));
                issuse1.setIssusDate(result.getString(3));
                issuse1.setMemberId(result.getString(4));
                issuse1.setDueDate(result.getString(5));
                issuse1.setIssuseQty(result.getString(6));

                issuses.add(issuse1);
            }
            return issuses;
        }

}



