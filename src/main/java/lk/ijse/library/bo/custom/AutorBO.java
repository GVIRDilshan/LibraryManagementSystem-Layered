package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.AutorDTO;

import java.sql.SQLException;

public interface AutorBO {
    public boolean AutorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public String AutorsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean AutorDelete(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public boolean AutorUpdate(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
    public boolean AutorGenarateTurnId() throws SQLException, ClassNotFoundException;

}
