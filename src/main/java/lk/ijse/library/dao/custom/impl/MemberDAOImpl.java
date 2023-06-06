package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.bo.custom.MemberBO;
import lk.ijse.library.dao.custom.MemberDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public boolean add(Member dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into Member values(?,?,?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,dto.getId());
        stm.setObject(2,dto.getName());
        stm.setObject(3,dto.getAddress());
        stm.setObject(5,dto.getAge());
        stm.setObject(4,dto.getContact());
        stm.setObject(6,dto.getEmail());
        stm.setObject(7,dto.getGender());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean update(Member dto) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update member set name=?,address=?,contact=?,age=?,email=?,Gender=? where memberId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, dto.getName());
        stm.setObject(2, dto.getAddress());
        stm.setObject(3, dto.getContact());
        stm.setObject(4, dto.getAge());
        stm.setObject(5, dto.getEmail());
        stm.setObject(6, dto.getGender());
        stm.setObject(7, dto.getId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from member where memberId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Member search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from member where memberId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            Member member = new Member();
            member.setId(result.getString(1));
            member.setName(result.getString(2));
            member.setAddress(result.getString(3));
            member.setContact(result.getString(4));
            member.setAge(Integer.parseInt(result.getString(5)));
            member.setEmail(result.getString(6));
            member.setGender(result.getString(7));
            return member;
        }
        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select memberId from member";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> MemberIds = new ArrayList<>();

        while (result.next()) {
            MemberIds.add(result.getString(1));
        }
        return MemberIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT memberId FROM Member ORDER BY memberId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastMemberId = rs.getString(1);

            String[] temp = lastMemberId.split("M");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "M00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "M0" + nextValue;
            }else {
                return "M";
            }
        }
        return  "M001";
    }

    @Override
    public ArrayList<Member> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from member";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Member> members = new ArrayList<>();

        while (result.next()) {
            Member member = new Member();

            member.setId(result.getString(1));
            member.setName(result.getString(2));
            member.setAddress(result.getString(3));
            member.setContact(result.getString(4));
            member.setAge(Integer.parseInt(result.getString(5)));
            member.setEmail(result.getString(6));
            member.setGender(result.getString(7));

            members.add(member);
        }
        return members;
    }

    @Override
    public ArrayList<String> loadAllMemberEmails() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select Email from member";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> Email = new ArrayList<>();

        while (result.next()) {
            Email.add(result.getString(1));
        }
        return Email;
    }
}
