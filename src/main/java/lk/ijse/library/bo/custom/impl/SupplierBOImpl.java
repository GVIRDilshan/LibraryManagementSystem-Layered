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
    public boolean supplierAdd(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.add(new Supplier(supplier.getSupplierID(),supplier.getSupplierName(),
                supplier.getSupplierContact(), supplier.getSupplierAddress(),supplier.getBookID()));
        return false;
    }

    @Override
    public Supplier supplierSearchFrom(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.search(id);
    }

    @Override
    public boolean supplierDelete(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.delete(id);
    }

    @Override
    public boolean supplierUpdate(SupplierDTO supplier) throws SQLException, ClassNotFoundException {
        supplierDAO.update(new Supplier(supplier.getSupplierID(),supplier.getSupplierName(),
                supplier.getSupplierContact(), supplier.getSupplierAddress(),supplier.getBookID()));
        return false;
    }

    @Override
    public String supplierGenarateTurnId() throws SQLException, ClassNotFoundException {
        return supplierDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllSupplierIds() throws SQLException, ClassNotFoundException {
      return supplierDAO.loadAllIds();
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
