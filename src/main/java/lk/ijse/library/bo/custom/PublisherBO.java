package lk.ijse.library.bo.custom;

import lk.ijse.library.dto.PublisherDTO;
import lk.ijse.library.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherBO {
    public boolean DonetionAdd(PublisherDTO publisher) throws SQLException, ClassNotFoundException;
    public Publisher DonetionsearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean DonetionDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean DonetionUpdate(PublisherDTO publisher) throws SQLException, ClassNotFoundException;
    public String DonetionGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAllDonetionIds() throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAllDonetion() throws SQLException, ClassNotFoundException;
}
