package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.AutorDTO;

import java.sql.SQLException;

public interface AutorBO {
    public boolean AutorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException;
}
