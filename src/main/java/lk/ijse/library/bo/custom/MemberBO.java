package lk.ijse.library.bo.custom;

import lk.ijse.library.bo.SuperBO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberBO extends SuperBO {
    public boolean memberAdd(MemberDTO member) throws SQLException, ClassNotFoundException;
    public MemberDTO membersearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean memberDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean memberUpdate(MemberDTO member) throws SQLException, ClassNotFoundException;
    public String memberGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllMemberIds() throws SQLException, ClassNotFoundException;
    public ArrayList<MemberDTO> loadAllMember() throws SQLException, ClassNotFoundException;
}
