package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.SupplierBO;
import lk.ijse.library.dao.custom.impl.SuplierDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.SupplierDTO;
import lk.ijse.library.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {

    SuplierDAOImpl supplierDAO = new SuplierDAOImpl();

    @Override
    public boolean SupplierAdd(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.add(new Supplier(supplier.getSupplierID(),supplier.getSupplierName(),
                supplier.getSupplierContact(), supplier.getSupplierAddress(),supplier.getBookID()));
        return false;
    }

    @Override
    public Supplier SuppliersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }

    @Override
    public boolean SupplierDelete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean SupplierUpdate(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.update(new Supplier(supplier.getSupplierID(),supplier.getSupplierName(),
                supplier.getSupplierContact(), supplier.getSupplierAddress(),supplier.getBookID()));
        return false;
    }

    @Override
    public String SupplierGenarateTurnId() throws SQLException, ClassNotFoundException {
        return supplierDAO.generateNewID();
    }

    @Override
    public ArrayList<SupplierDTO> loadAllSupplierIds() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList<>();
        ArrayList<String> all = new SuplierDAOImpl().loadAllIds();
        for (String b :  all) {
            allSuppliers.add(new SupplierDTO());
        }
        return allSuppliers;
    }

    @Override
    public ArrayList<SupplierDTO> loadAllSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDTO> allSuppliers = new ArrayList<>();
        ArrayList<Supplier> all = new SuplierDAOImpl().loadAll();
        for (Supplier b :  all) {
            allSuppliers.add(new SupplierDTO());
        }
        return allSuppliers;
    }
}
