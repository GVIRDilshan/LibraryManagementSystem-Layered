package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.ExibitionDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExibitionBO extends SuperBO {
    public boolean exibitionAdd(ExibitionDTO exibition) throws SQLException, ClassNotFoundException;
    public Exibition exibitionsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean exibitionDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean exibitionUpdate(ExibitionDTO exibition) throws SQLException, ClassNotFoundException;
    public String exibitionGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<ExibitionDTO> loadAllExibitionIds() throws SQLException, ClassNotFoundException;
    public ArrayList<ExibitionDTO> loadAllExibition() throws SQLException, ClassNotFoundException;
}
