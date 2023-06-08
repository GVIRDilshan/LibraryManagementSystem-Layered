package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.MemberBO;
import lk.ijse.library.dao.custom.impl.MemberDAOImpl;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberBOImpl implements MemberBO {

    MemberDAOImpl memberDAO = new MemberDAOImpl();

    @Override
    public boolean MemberAdd(MemberDTO member) throws SQLException, ClassNotFoundException {
        memberDAO.add(new Member());
        return false;
    }

    @Override
    public Member MembersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean MemberDelete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean MemberUpdate(MemberDTO member) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String MemberGenarateTurnId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MemberDTO> loadAllMemberIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<MemberDTO> loadAllMember() throws SQLException, ClassNotFoundException {
        return null;
    }
}
