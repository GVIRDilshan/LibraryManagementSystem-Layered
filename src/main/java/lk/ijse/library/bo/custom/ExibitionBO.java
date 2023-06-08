package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.ExibitionDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExibitionBO {
    public boolean ExibitionAdd(ExibitionDTO exibition) throws SQLException, ClassNotFoundException;
    public Exibition ExibitionsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean ExibitionDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean ExibitionUpdate(ExibitionDTO exibition) throws SQLException, ClassNotFoundException;
    public String ExibitionGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<ExibitionDTO> loadAllExibitionIds() throws SQLException, ClassNotFoundException;
    public ArrayList<ExibitionDTO> loadAllExibition() throws SQLException, ClassNotFoundException;
}
