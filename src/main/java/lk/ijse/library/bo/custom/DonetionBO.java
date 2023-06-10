package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.DonetionDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Donetion;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DonetionBO extends SuperBO {
    public boolean donetionAdd(DonetionDTO donetion) throws SQLException, ClassNotFoundException;
    public Donetion donetionsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean donetionDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean donetionUpdate(DonetionDTO donetion) throws SQLException, ClassNotFoundException;
    public String donetionGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<DonetionDTO> loadAllDonetionIds() throws SQLException, ClassNotFoundException;
    public ArrayList<DonetionDTO> loadAllDonetion() throws SQLException, ClassNotFoundException;
}

