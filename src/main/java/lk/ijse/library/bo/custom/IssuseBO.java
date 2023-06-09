package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Issuse;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IssuseBO extends SuperBO {
    public  boolean issuseFrom(IssuseDTO issuse, String qty, String Bookd) throws SQLException, ClassNotFoundException;
    public Issuse searchIssuseFrom(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<IssuseDTO> loadAllIssuses() throws SQLException, ClassNotFoundException;
}
