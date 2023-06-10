package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.entity.Autor;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AutorBO extends SuperBO {
    public boolean autorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public AutorDTO autorsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean autorDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean autorUpdate(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public String autorGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllAutorIds() throws SQLException;
    public ArrayList<AutorDTO> loadAllAutors() throws SQLException, ClassNotFoundException;

}
