package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.custom.SupplierDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.SupplierDTO;
import lk.ijse.library.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SuplierDAOImpl implements SupplierDAO {
    @Override
    public boolean add(Supplier dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into supplier values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getSupplierID());
        stm.setObject(2,dto.getSupplierName());
        stm.setObject(3,dto.getSupplierContact());
        stm.setObject(4,dto.getSupplierAddress());
        stm.setObject(5,dto.getBookID());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Supplier dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update supplier set name=?,Contact=?,Addresse=?, Book_Id=? where SupplierId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getSupplierName());
        stm.setObject(2,dto.getSupplierAddress());
        stm.setObject(3,dto.getSupplierContact());
        stm.setObject(4,dto.getBookID());
        stm.setObject(5,dto.getSupplierID());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from supplier where SupplierId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Supplier search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from supplier where  SupplierId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Supplier supplier = new Supplier();
            supplier.setSupplierID(result.getString(1));
            supplier.setSupplierName(result.getString(2));
            supplier.setSupplierAddress(result.getString(3));
            supplier.setSupplierContact(result.getString(4));
            supplier.setBookID(result.getString(5));
            return supplier;
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select SupplierId from supplier";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> SupplierIds = new ArrayList<>();

        while (result.next()) {
            SupplierIds.add(result.getString(1));
        }
        return SupplierIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT SupplierId FROM supplier ORDER BY SupplierId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastAutorId = rs.getString(1);

            String[] temp = lastAutorId.split("A");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "S00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "S0" + nextValue;
            }else {
                return "S";
            }
        }
        return  "S001";
    }

    @Override
    public ArrayList<Supplier> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from supplier";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Supplier> suppliers = new ArrayList<>();

        while (result.next()) {
            Supplier supplier = new Supplier();
            supplier.setSupplierID(result.getString(1));
            supplier.setSupplierName(result.getString(2));
            supplier.setSupplierContact(result.getString(3));
            supplier.setSupplierAddress(result.getString(4));
            supplier.setBookID(result.getString(5));

            suppliers.add(supplier);
        }
        return suppliers;
    }
}
