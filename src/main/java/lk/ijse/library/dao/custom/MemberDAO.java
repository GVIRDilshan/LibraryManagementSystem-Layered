package lk.ijse.library.dao.custom;

import lk.ijse.library.dao.CrudDAO;
import lk.ijse.library.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAO extends CrudDAO<Member> {
    public  ArrayList<String> loadAllMemberEmails() throws SQLException;
}
