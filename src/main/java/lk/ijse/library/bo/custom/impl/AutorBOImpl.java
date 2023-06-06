package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.AutorBO;
import lk.ijse.library.dao.custom.AutorDAO;
import lk.ijse.library.dao.custom.impl.AutorDAOImpl;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.entity.Autor;
import org.checkerframework.checker.units.qual.A;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutorBOImpl implements AutorBO {
    @Override
    public boolean AutorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException {
        AutorDAOImpl autorDAO = new AutorDAOImpl();
        /*
        methanin(autorDAO.add( new Autor(...) )) parameter ek entity package eke Autor object ekk vidiyta yavanna..ethod dao eke
        use venne entity package eke object vitharai.. dn ethota AutorDAO eke CrudDAO ek extend karanota
        Autor object ek danna genertic type ek vidiyata AutorDTO nathuva
        */
        autorDAO.add(new Autor(Aotor.getAutorID(),Aotor.getAutorName(),Aotor.getBookName(),Aotor.getBookID()));
        return false;

    }

    @Override
    public String AutorsearchFrom(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean AutorDelete(String id) throws SQLException, ClassNotFoundException {
        AutorDAOImpl autorDAO = new AutorDAOImpl();
        return autorDAO.delete(id);
    }

    @Override
    public boolean AutorUpdate(AutorDTO Aotor) throws SQLException, ClassNotFoundException {
        AutorDAOImpl autorDAO = new AutorDAOImpl();
        autorDAO.update(new Autor(Aotor.getAutorName(),Aotor.getBookName(),Aotor.getBookID(),Aotor.getAutorID()));
        return false;
    }

    @Override
    public String AutorGenarateTurnId() throws SQLException, ClassNotFoundException {
       AutorDAOImpl autorDAO = new AutorDAOImpl();
       return autorDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllAutorIds() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<AutorDTO> loadAllAutors() throws SQLException, ClassNotFoundException {
        ArrayList<AutorDTO> allAutors = new ArrayList<>();
        ArrayList<Autor> all = new AutorDAOImpl().loadAll();
        for (Autor a : all) {
            allAutors.add(new AutorDTO(a.getAutorID(),a.getAutorName(),a.getBookName(),a.getBookID()));
        }
        return allAutors;
    }
}