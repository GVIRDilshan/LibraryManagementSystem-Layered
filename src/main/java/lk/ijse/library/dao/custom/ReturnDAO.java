package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.ReturnDTO;
import lk.ijse.library.entity.Return;

import java.sql.SQLException;

public interface ReturnDAO extends CrudDAO<Return> {
    public boolean ReturnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException;
}
