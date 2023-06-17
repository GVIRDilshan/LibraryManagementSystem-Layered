package lk.ijse.library.Model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.SupplierDTO;

import java.sql.*;
import java.util.ArrayList;

public class SupplierModel {

    public static boolean SupplierAdd(SupplierDTO supplier) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into supplier values(?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,supplier.getSupplierID());
        stm.setObject(2,supplier.getSupplierName());
        stm.setObject(3,supplier.getSupplierContact());
        stm.setObject(4,supplier.getSupplierAddress());
        stm.setObject(5,supplier.getBookID());

        return stm.executeUpdate() > 0;
    }
    public static SupplierDTO searchFrom(String id) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from supplier where  SupplierId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
           SupplierDTO supplier = new SupplierDTO();
           supplier.setSupplierID(result.getString(1));
           supplier.setSupplierName(result.getString(2));
           supplier.setSupplierAddress(result.getString(3));
           supplier.setSupplierContact(result.getString(4));
           supplier.setBookID(result.getString(5));
            return supplier;
        }
        return null;
    }
    public static Boolean updateMember(SupplierDTO supplier) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update supplier set name=?,Contact=?,Addresse=?, Book_Id=? where SupplierId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,supplier.getSupplierName());
        stm.setObject(2,supplier.getSupplierAddress());
        stm.setObject(3,supplier.getSupplierContact());
        stm.setObject(4,supplier.getBookID());
        stm.setObject(5,supplier.getSupplierID());

        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }
    public static boolean deleteFrom(String id) throws SQLException {
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
    public static ArrayList<String> loadAllSupplierIds() throws SQLException {

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
    public static ArrayList<SupplierDTO> loadAllSuppliers() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from supplier";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<SupplierDTO> suppliers = new ArrayList<>();

        while (result.next()) {
            SupplierDTO supplier = new SupplierDTO();
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
