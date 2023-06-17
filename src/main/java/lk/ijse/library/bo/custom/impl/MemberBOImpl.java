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
    public boolean memberAdd(MemberDTO member) throws SQLException, ClassNotFoundException {
        return memberDAO.add(new Member(member.getId(), member.getName(),
                member.getAddress(),member.getContact(),
                member.getAge(), member.getEmail(),
                member.getGender()));
    }

    @Override
    public MemberDTO membersearchFrom(String id) throws SQLException, ClassNotFoundException {
        Member member = memberDAO.search(id);
        return new MemberDTO(member.getId(), member.getName(), member.getAddress()
                ,member.getContact(), member.getAge(), member.getEmail(),
                member.getGender());
    }

    @Override
    public boolean memberDelete(String id) throws SQLException, ClassNotFoundException {
        return memberDAO.delete(id);
    }

    @Override
    public boolean memberUpdate(MemberDTO member) throws SQLException, ClassNotFoundException {
        memberDAO.update(new Member(member.getId(), member.getName(),
                member.getAddress(),member.getContact(),
                member.getAge(), member.getEmail(),
                member.getGender()));
        return false;
    }

    @Override
    public String memberGenarateTurnId() throws SQLException, ClassNotFoundException {
        return memberDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllMemberIds() throws SQLException, ClassNotFoundException {
        return memberDAO.loadAllIds();
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