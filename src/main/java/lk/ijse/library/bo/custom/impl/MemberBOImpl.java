package lk.ijse.library.bo.custom.impl;

import lk.ijse.library.bo.custom.MemberBO;
import lk.ijse.library.dao.custom.impl.MemberDAOImpl;
import lk.ijse.library.dto.BookDTO;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberBOImpl implements MemberBO {

    MemberDAOImpl memberDAO = new MemberDAOImpl();

    @Override
    public boolean MemberAdd(MemberDTO member) throws SQLException, ClassNotFoundException {
        memberDAO.add(new Member(member.getId(), member.getName(),
                member.getAddress(),member.getAge(),
                member.getContact(), member.getEmail(),
                member.getGender()));
        return false;
    }

    @Override
    public Member MembersearchFrom(String id) throws SQLException, ClassNotFoundException {
        return memberDAO.search(id);
    }

    @Override
    public boolean MemberDelete(String id) throws SQLException, ClassNotFoundException {
        return memberDAO.delete(id);
    }

    @Override
    public boolean MemberUpdate(MemberDTO member) throws SQLException, ClassNotFoundException {
        memberDAO.update(new Member(member.getId(), member.getName(),
                member.getAddress(),member.getAge(),
                member.getContact(), member.getEmail(),
                member.getGender()));
        return false;
    }

    @Override
    public String MemberGenarateTurnId() throws SQLException, ClassNotFoundException {
        return memberDAO.generateNewID();
    }

    @Override
    public ArrayList<MemberDTO> loadAllMemberIds() throws SQLException, ClassNotFoundException {
        ArrayList<MemberDTO> allMembers = new ArrayList<>();
        ArrayList<String> all = new MemberBOImpl().memberDAO.loadAllIds();
        for (String b :  all) {
            allMembers.add(new MemberDTO());
        }
        return allMembers;
    }

    @Override
    public ArrayList<MemberDTO> loadAllMember() throws SQLException, ClassNotFoundException {
        ArrayList<MemberDTO> allMembers = new ArrayList<>();
        ArrayList<Member> all = new MemberBOImpl().memberDAO.loadAll();
        for (Member b :  all) {
            allMembers.add(new MemberDTO());
        }
        return allMembers;
    }
}
