package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.ReturnBO;
import lk.ijse.library.dto.ReturnDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReturnBOImpl implements ReturnBO {
    @Override
    public boolean ReturnSet(ReturnDTO returns, String Qty, String BookId, String IssuseID) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<ReturnDTO> loadAllDonetion() throws SQLException, ClassNotFoundException {
        return null;
    }
}
