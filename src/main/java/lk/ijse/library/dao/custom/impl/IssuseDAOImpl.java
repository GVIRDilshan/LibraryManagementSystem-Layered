package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dao.custom.IssuseDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.entity.Issuse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssuseDAOImpl implements IssuseDAO {
    @Override
    public boolean issuseFrom(IssuseDTO issuse, String qty, String Bookd) throws SQLException {
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

    @Override
    public Issuse search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from issuse where iid = ?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

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

    @Override
    public ArrayList<Issuse> loadAll() throws SQLException, ClassNotFoundException {

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
    public ArrayList<String> loadAllIds() throws SQLException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }
}
