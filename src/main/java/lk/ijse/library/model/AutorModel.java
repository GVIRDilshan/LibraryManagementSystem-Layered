package lk.ijse.library.model;

import lk.ijse.library.db.DBConnection;
import lk.ijse.library.dto.AutorDTO;

import java.sql.*;
import java.util.ArrayList;

public class AutorModel {
    public static boolean AutorAdd(AutorDTO Aotor) throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "insert into autor values(?,?,?,?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,Aotor.getAutorID());
        stm.setObject(2,Aotor.getAutorName());
        stm.setObject(3,Aotor.getBookName());
        stm.setObject(4,Aotor.getBookID());

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static AutorDTO searchFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select * from autor where AutorId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1,id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            AutorDTO autor = new AutorDTO();
            autor.setAutorID(result.getString(1));
            autor.setAutorName(result.getString(2));
            autor.setBookID(result.getString(3));
            autor.setBookName(result.getString(4));

            return autor;
        }
        return null;
    }
    
    public static Boolean updateAutor(AutorDTO autor) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "update autor set name=?, BookName=?,Book_Id=? where AutorId=?";

        PreparedStatement stm = con.prepareStatement(sql);


        stm.setObject(1,autor.getAutorName());
        stm.setObject(2,autor.getBookName());
        stm.setObject(3,autor.getBookID());
        stm.setObject(4,autor.getAutorID());

        int result = stm.executeUpdate();

        if (result == 1) {
            return true;
        }
        return null;
    }
    
    public static boolean deleteFrom(String id) throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "delete from autor where AutorId =?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        int result = stm.executeUpdate();

        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static ArrayList<String> loadAllAutorIds() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select  AutorId from Autor";

        PreparedStatement stm = con.prepareStatement(sql);

            ResultSet result = stm.executeQuery();

            ArrayList<String> AutorIds = new ArrayList<>();

            while (result.next()) {
               AutorIds.add(result.getString(1));
            }
            return AutorIds;
    }
    
    public static ArrayList<AutorDTO> loadAllAutors() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from autor";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<AutorDTO> autors = new ArrayList<>();

        while (result.next()) {
            AutorDTO autor = new AutorDTO();
            autor.setAutorID(result.getString(1));
            autor.setAutorName(result.getString(2));
            autor.setBookName(result.getString(3));
            autor.setBookID(result.getString(4));

            autors.add(autor);
        }

        return autors;
    }
    public static String genarateTurnId() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT autorId FROM autor ORDER BY autorId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastAutorId = rs.getString(1);

            String[] temp = lastAutorId.split("A");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "A00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "A0" + nextValue;
            }else {
                return "A";
            }


        }
        return  "A001";
    }
}
