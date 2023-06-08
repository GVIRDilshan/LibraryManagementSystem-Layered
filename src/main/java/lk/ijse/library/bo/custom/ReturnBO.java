package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.ReturnDTO;
import lk.ijse.library.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReturnBO {
    public  boolean ReturnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException;
    public ArrayList<ReturnDTO> loadAllDonetion() throws SQLException, ClassNotFoundException;
}
