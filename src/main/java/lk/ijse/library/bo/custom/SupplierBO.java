package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.SupplierDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Supplier;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public boolean SupplierAdd(SupplierDTO supplier) throws SQLException, ClassNotFoundException;
    public Supplier SupplierSearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean SupplierDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean SupplierUpdate(SupplierDTO supplier) throws SQLException, ClassNotFoundException;
    public String SupplierGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<SupplierDTO> loadAllSupplierIds() throws SQLException, ClassNotFoundException;
    public ArrayList<SupplierDTO> loadAllSupplier() throws SQLException, ClassNotFoundException;
}
