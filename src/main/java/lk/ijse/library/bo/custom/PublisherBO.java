package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.PublisherDTO;
import lk.ijse.library.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherBO extends SuperBO {
    public boolean publisherAdd(PublisherDTO publisher) throws SQLException, ClassNotFoundException;
    public Publisher publishersearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean publisherDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean publisherUpdate(PublisherDTO publisher) throws SQLException, ClassNotFoundException;
    public String publisherGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllPublisherIds() throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAllPublisher() throws SQLException, ClassNotFoundException;
}
