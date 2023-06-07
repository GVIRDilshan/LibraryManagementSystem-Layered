package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.dto.IssuseDTO;
import lk.ijse.library.entity.Issuse;

import java.sql.SQLException;

public interface IssuseDAO extends CrudDAO<Issuse> {
    public  boolean issuseFrom(IssuseDTO issuse, String qty, String Bookd) throws SQLException;
}
