package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.ReturnDTO;
import lk.ijse.library.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReturnBO extends SuperBO {
    public  boolean returnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException;
    public ArrayList<ReturnDTO> loadAll() throws SQLException, ClassNotFoundException;
}
