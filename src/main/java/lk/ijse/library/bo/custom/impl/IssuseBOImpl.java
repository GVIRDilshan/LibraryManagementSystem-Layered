package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.IssuseBO;
import lk.ijse.library.dao.custom.impl.IssuseDAOImpl;
import lk.ijse.library.dto.AutorDTO;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.entity.Autor;
import lk.ijse.library.entity.Issuse;

import java.sql.SQLException;
import java.util.ArrayList;

public class IssuseBOImpl implements IssuseBO {

    IssuseDAOImpl issuseDAO = new IssuseDAOImpl();

    @Override
    public boolean issuseFrom(IssuseDTO issuse, String qty, String bookId) throws SQLException, ClassNotFoundException {
        return issuseDAO.issuseFrom(issuse , qty , bookId);
    }

    @Override
    public IssuseDTO searchIssuseFrom(String id) throws SQLException, ClassNotFoundException {
        Issuse issuse = issuseDAO.search(id);
        return new IssuseDTO(issuse.getIssusId(),issuse.getIssusDate() , issuse.getMemberId(), issuse.getBookId() , issuse.getDueDate() , issuse.getIssuseQty() );
    }

    @Override
    public ArrayList<IssuseDTO> loadAllIssuses() throws SQLException, ClassNotFoundException {
        ArrayList<IssuseDTO> allIssuse = new ArrayList<>();

        for (Issuse i : issuseDAO.loadAll()) {
            allIssuse.add(new IssuseDTO(i.getIssusId(),i.getBookId(),
                    i.getIssusDate(),i.getMemberId(),i.getDueDate(),i.getIssuseQty()));
        }
        return allIssuse;
    }
}
