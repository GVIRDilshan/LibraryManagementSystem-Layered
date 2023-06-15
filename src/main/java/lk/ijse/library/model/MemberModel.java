package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.MemberDTO;
import lk.ijse.library.entity.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberModel {

    public static boolean memberAdd(MemberDTO member) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into Member values(?,?,?,?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

            stm.setObject(1, member.getId());
            stm.setObject(2,member.getName());
            stm.setObject(3,member.getAddress());
            stm.setObject(5,member.getAge());
            stm.setObject(4,member.getContact());
            stm.setObject(6,member.getEmail());
            stm.setObject(7,member.getGender());

        return stm.executeUpdate() > 0;
    }
    public static MemberDTO searchFrom(String id) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from member where memberId=?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            MemberDTO member = new MemberDTO();
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
    public static Boolean updateMember(Member member) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update member set name=?,address=?,contact=?,age=?,email=?,Gender=? where memberId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, member.getName());
        stm.setObject(2, member.getAddress());
        stm.setObject(3, member.getContact());
        stm.setObject(4, member.getAge());
        stm.setObject(5,member.getEmail());
        stm.setObject(6,member.getGender());
        stm.setObject(7, member.getId());


        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }
    public static boolean deleteFrom(String id) throws SQLException {
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
    public static ArrayList<MemberDTO> loadAllMember() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from member";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet result = stm.executeQuery();

            ArrayList<MemberDTO> members = new ArrayList<>();

            while (result.next()) {
                MemberDTO member = new MemberDTO();

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
    public static ArrayList<String> loadAllMemberIds() throws SQLException {

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

    public static ArrayList<String> loadAllMemberEmails() throws SQLException {

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
    public static String genarateTurnId() throws SQLException {
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
}
