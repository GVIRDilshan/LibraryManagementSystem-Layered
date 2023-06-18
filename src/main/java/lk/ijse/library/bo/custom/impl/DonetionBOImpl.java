package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.DonetionBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.impl.DonetionDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.DonetionDTO;
import lk.ijse.library.entity.Book;
import lk.ijse.library.entity.Donetion;

import java.sql.SQLException;
import java.util.ArrayList;
public class DonetionBOImpl implements DonetionBO {

    DonetionDAOImpl donetionDAO = (DonetionDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DONETION);

    @Override
    public boolean donetionAdd(DonetionDTO donetion) throws SQLException, ClassNotFoundException {
        donetionDAO.add(new Donetion(donetion.getDonetionId(),donetion.getAmmount(),donetion.getReview(), donetion.getDonetionName(), donetion.getExibitionId()));
        return false;
    }

    @Override
    public Donetion donetionsearchFrom(String id) throws SQLException, ClassNotFoundException {
        return donetionDAO.search(id);
    }

    @Override
    public boolean donetionDelete(String id) throws SQLException, ClassNotFoundException {
        return donetionDAO.delete(id);
    }

    @Override
    public boolean donetionUpdate(DonetionDTO donetion) throws SQLException, ClassNotFoundException {
        donetionDAO.update(new Donetion(donetion.getDonetionId(),donetion.getAmmount(),donetion.getReview(),donetion.getDonetionName(),donetion.getExibitionId()));
        return false;
    }

    @Override
    public String donetionGenarateTurnId() throws SQLException, ClassNotFoundException {
        return donetionDAO.generateNewID();
    }

    @Override
    public ArrayList<DonetionDTO> loadAllDonetionIds() throws SQLException, ClassNotFoundException {
        ArrayList<DonetionDTO> allDonet = new ArrayList<>();
        ArrayList<String> all = new BookBOImpl().bookDAO.loadAllIds();
        for (String b :  all) {
            allDonet.add(new DonetionDTO());
        }
        return allDonet;
    }

    @Override
    public ArrayList<DonetionDTO> loadAllDonetion() throws SQLException, ClassNotFoundException {
        ArrayList<DonetionDTO> allDonet = new ArrayList<>();
        ArrayList<Book> all = new BookBOImpl().bookDAO.loadAll();
        for (Book b :  all) {
            allDonet.add(new DonetionDTO());
        }
        return allDonet;
    }
}