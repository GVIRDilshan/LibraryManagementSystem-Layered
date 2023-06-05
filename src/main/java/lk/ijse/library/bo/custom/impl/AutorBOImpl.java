package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.AutorBO;
import lk.ijse.library.dao.custom.impl.AutorDAOImpl;
import lk.ijse.library.dto.AutorDTO;

import java.sql.SQLException;

public class AutorBOImpl implements AutorBO {
    @Override
    public boolean AutorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException {
        AutorDAOImpl autorDAO = new AutorDAOImpl();

        /*
        methanin(autorDAO.add( new Autor(...) )) parameter ek entity package eke Autor object ekk vidiyta yavanna..ethod dao eke
        use venne entity package eke object vitharai.. dn ethota AutorDAO eke CrudDAO ek extend karanota
        Autor object ek danna genertic type ek vidiyata AutorDTO nathuva
        */

        autorDAO.add(new AutorDTO(Aotor.getAutorID(),Aotor.getAutorName(),Aotor.getBookName(),Aotor.getBookID()));
        return false;
    }
}
