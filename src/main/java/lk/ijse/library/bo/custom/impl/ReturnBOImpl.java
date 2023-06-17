package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.ReturnBO;
import lk.ijse.library.dao.DAOFactory;
import lk.ijse.library.dao.custom.ReturnDAO;
import lk.ijse.library.dao.custom.impl.ReturnDAOImpl;
import lk.ijse.library.dto.ReturnDTO;
import lk.ijse.library.entity.Return;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnBOImpl implements ReturnBO {

    ReturnDAO returnDAO = (ReturnDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RETURN);

    @Override
    public boolean returnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException {
        return returnDAO.ReturnSet(new Return(
                returns.getReturnId(),
                returns.getIssuseId(),
                returns.getRreturnQty(),
                returns.getReturnDate() ,
                returns.getBookId(),
                returns.getIssuseDate()),
                Qty,BookId,IssuseID);
    }

    @Override
    public ArrayList<ReturnDTO> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<ReturnDTO> allReturns = new ArrayList<>();

        for (Return r : returnDAO.loadAll()) {
            allReturns.add(new ReturnDTO(r.getReturnId(),r.getReturnDate(),r.getIssuseId(),r.getIssuseDate(),r.getBookId()));
        }
        return allReturns;
    }
}
