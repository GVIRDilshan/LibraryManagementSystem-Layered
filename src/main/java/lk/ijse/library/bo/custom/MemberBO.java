package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberBO extends SuperBO {
    public boolean MemberAdd(MemberDTO member) throws SQLException, ClassNotFoundException;
    public Member MembersearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean MemberDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean MemberUpdate(MemberDTO member) throws SQLException, ClassNotFoundException;
    public String MemberGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<MemberDTO> loadAllMemberIds() throws SQLException, ClassNotFoundException;
    public ArrayList<MemberDTO> loadAllMember() throws SQLException, ClassNotFoundException;
}
