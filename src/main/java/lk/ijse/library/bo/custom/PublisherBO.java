package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.PublisherDTO;
import lk.ijse.library.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherBO extends SuperBO {
    public boolean PublisherAdd(PublisherDTO publisher) throws SQLException, ClassNotFoundException;
    public Publisher PublishersearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean PublisherDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean PublisherUpdate(PublisherDTO publisher) throws SQLException, ClassNotFoundException;
    public String PublisherGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAllPublisherIds() throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAllPublisher() throws SQLException, ClassNotFoundException;
}
