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

    AutorDAOImpl autorDAO = new AutorDAOImpl();
    @Override
    public boolean autorAdd(AutorDTO Aotor) throws SQLException, ClassNotFoundException {
        return autorDAO.add(new Autor(Aotor.getAutorID(), Aotor.getAutorName(), Aotor.getBookName(), Aotor.getBookID()));
    }

    @Override
    public AutorDTO autorsearchFrom(String id) throws SQLException, ClassNotFoundException {
        Autor autor = autorDAO.search(id);
       // System.out.println(autor.getAutorID());

        return new AutorDTO(autor.getAutorID() , autor.getAutorName(), autor.getBookName(), autor.getBookID() );

    }

    @Override
    public boolean autorDelete(String id) throws SQLException, ClassNotFoundException {
        return autorDAO.delete(id);
    }

    @Override
    public boolean autorUpdate(AutorDTO Aotor) throws SQLException, ClassNotFoundException {
       return autorDAO.update(new Autor(Aotor.getAutorName(),Aotor.getBookName(),Aotor.getBookID(),Aotor.getAutorID()));
       // System.out.println();
    }

    @Override
    public String autorGenarateTurnId() throws SQLException, ClassNotFoundException {
       return autorDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllAutorIds() throws SQLException {
        return autorDAO.loadAllIds();
    }

    @Override
    public ArrayList<AutorDTO> loadAllAutors() throws SQLException, ClassNotFoundException {
        ArrayList<AutorDTO> allAutors = new ArrayList<>();

        for (Autor a : autorDAO.loadAll()) {
            allAutors.add(new AutorDTO(a.getAutorID(),a.getAutorName(),a.getBookName(),a.getBookID()));
        }

        return allAutors;
    }
}