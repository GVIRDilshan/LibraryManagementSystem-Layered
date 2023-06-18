package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.ExibitionBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.impl.ExibitionDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.ExibitionDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Exibition;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExibitionBOImpl implements ExibitionBO {

    ExibitionDAOImpl exibitionDAO = (ExibitionDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXIBITION);

    @Override
    public boolean exibitionAdd(ExibitionDTO exibition) throws SQLException, ClassNotFoundException {
        exibitionDAO.add(new Exibition(exibition.getExibitionId(),exibition.getExibitionDate(),exibition.getExibitionTime(),exibition.getExibitionDesc()));
        return false;
    }

    @Override
    public Exibition exibitionsearchFrom(String id) throws SQLException, ClassNotFoundException {
        return exibitionDAO.search(id);
    }

    @Override
    public boolean exibitionDelete(String id) throws SQLException, ClassNotFoundException {
        return exibitionDAO.delete(id);
    }

    @Override
    public boolean exibitionUpdate(ExibitionDTO exibition) throws SQLException, ClassNotFoundException {
        exibitionDAO.update(new Exibition(exibition.getExibitionId(), exibition.getExibitionDate(), exibition.getExibitionTime(), exibition.getExibitionDesc()));
        return false;
    }

    @Override
    public String exibitionGenarateTurnId() throws SQLException, ClassNotFoundException {
        return exibitionDAO.generateNewID();
    }

    @Override
    public ArrayList<ExibitionDTO> loadAllExibitionIds() throws SQLException, ClassNotFoundException {
        ArrayList<ExibitionDTO> allExibitions = new ArrayList<>();
        ArrayList<String> all = new ExibitionDAOImpl().loadAllIds();
        for (String b :  all) {
            allExibitions.add(new ExibitionDTO());
        }
        return allExibitions;
    }

    @Override
    public ArrayList<ExibitionDTO> loadAllExibition() throws SQLException, ClassNotFoundException {
        ArrayList<ExibitionDTO> allExibition = new ArrayList<>();
        ArrayList<Exibition> all = new ExibitionDAOImpl().loadAll();
        for (Exibition b :  all) {
            allExibition.add(new ExibitionDTO());
        }
        return allExibition;
    }
}
