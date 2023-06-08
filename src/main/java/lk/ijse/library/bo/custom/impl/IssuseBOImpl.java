package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.IssuseBO;
import lk.ijse.library.dao.custom.impl.IssuseDAOImpl;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.entity.Issuse;

import java.sql.SQLException;
import java.util.ArrayList;

public class IssuseBOImpl implements IssuseBO {

    IssuseDAOImpl issuseDAO = new IssuseDAOImpl();

    @Override
    public boolean issuseFrom(IssuseDTO issuse, String qty, String Bookd) throws SQLException {
      //  issuseDAO.issuseFrom(new IssuseDTO(issuse.getIssusId(),issuse.getBookId(),issuse.getIssusDate(),issuse.getMemberId(),issuse.getDueDate(),issuse.getIssuseQty()));
        return false;
    }

    @Override
    public Issuse searchIssuseFrom(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<IssuseDTO> loadAllIssuses() throws SQLException, ClassNotFoundException {
        return null;
    }
}
