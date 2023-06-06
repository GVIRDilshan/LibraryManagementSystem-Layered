package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.AutorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AutorBO {
    public boolean AutorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public String AutorsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean AutorDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean AutorUpdate(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public String AutorGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllAutorIds() throws SQLException;
    public ArrayList<AutorDTO> loadAllAutors() throws SQLException, ClassNotFoundException;

}
