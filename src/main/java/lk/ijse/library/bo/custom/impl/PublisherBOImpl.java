package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.PublisherBO;
import lk.ijse.library.dao.custom.impl.PublisherDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.PublisherDTO;
import lk.ijse.library.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherBOImpl implements PublisherBO {

    PublisherDAOImpl publisherDAO = new PublisherDAOImpl();
    @Override
    public boolean PublisherAdd(PublisherDTO publisher) throws SQLException, ClassNotFoundException {
        publisherDAO.add(new Publisher(publisher.getPublisherID(), publisher.getPublisherName(),
                publisher.getBookID(), publisher.getPublishDate()));
        return false;
    }

    @Override
    public Publisher PublishersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return publisherDAO.search(id);
    }

    @Override
    public boolean PublisherDelete(String id) throws SQLException, ClassNotFoundException {
        return publisherDAO.delete(id);
    }

    @Override
    public boolean PublisherUpdate(PublisherDTO publisher) throws SQLException, ClassNotFoundException {
        publisherDAO.update(new Publisher(publisher.getPublisherID(), publisher.getPublisherName(),
                publisher.getBookID(), publisher.getPublishDate()));
        return false;
    }

    @Override
    public String PublisherGenarateTurnId() throws SQLException, ClassNotFoundException {
        return publisherDAO.generateNewID();
    }

    @Override
    public ArrayList<PublisherDTO> loadAllPublisherIds() throws SQLException, ClassNotFoundException {
        ArrayList<PublisherDTO> allPublisher = new ArrayList<>();
        ArrayList<String> all = new PublisherDAOImpl().loadAllIds();
        for (String b :  all) {
            allPublisher.add(new PublisherDTO());
        }
        return allPublisher;
    }

    @Override
    public ArrayList<PublisherDTO> loadAllPublisher() throws SQLException, ClassNotFoundException {
        ArrayList<PublisherDTO> allPublisher = new ArrayList<>();
        ArrayList<Publisher> all = new PublisherDAOImpl().loadAll();
        for (Publisher b :  all) {
            allPublisher.add(new PublisherDTO());
        }
        return allPublisher;
    }
}
