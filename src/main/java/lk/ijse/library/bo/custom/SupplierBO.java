package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.SupplierDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public boolean supplierAdd(SupplierDTO supplier) throws SQLException, ClassNotFoundException;
    public Supplier supplierSearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean supplierDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean supplierUpdate(SupplierDTO supplier) throws SQLException, ClassNotFoundException;
    public String supplierGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllSupplierIds() throws SQLException, ClassNotFoundException;
    public ArrayList<SupplierDTO> loadAllSupplier() throws SQLException, ClassNotFoundException;
}
