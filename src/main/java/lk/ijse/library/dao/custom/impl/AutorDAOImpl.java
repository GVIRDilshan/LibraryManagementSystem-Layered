package lk.ijse.library.dao.custom.impl;

import lk.ijse.library.dao.SQLUtil;
import lk.ijse.library.dao.custom.AutorDAO;
import lk.ijse.library.db.DBConnection;
import lk.ijse.library.entity.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorDAOImpl implements AutorDAO {
    @Override
    public boolean add(Autor dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("insert into autor values(?,?,?,?)",dto.getAutorID(),
                dto.getAutorName(),dto.getBookName(),dto.getBookID());

    }
    @Override
    public Autor search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select * from autor where AutorId=?",id);

        if (resultSet.next() ){

            return new Autor(resultSet.getString(1) ,
                    resultSet.getString(2) ,
                    resultSet.getString(3) ,
                    resultSet.getString(4)
            );

        }
        return null;
    }

    @Override
    public boolean update(Autor dto) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("update autor set name=?,BookName=?,Book_Id=? where AutorId=?",dto.getAutorName(),
                dto.getBookName(),dto.getBookID(),dto.getAutorID());


    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("delete from autor where AutorId =?",id);

    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
     ResultSet rst =  SQLUtil.execute("SELECT autorId FROM autor ORDER BY autorId DESC LIMIT 1");
     if (rst.next()){
         String id = rst.getString("id");
         int newAutorId = Integer.parseInt(id.replace("A00-", "")) + 1;
         return String.format("A00-%03d", newAutorId);
     } else {
         return "A001";
     }
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
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

    @Override
    public ArrayList<Autor> loadAll() throws SQLException, ClassNotFoundException {
        ArrayList<Autor> allItems = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM autor");
        while (rst.next()) {
            allItems.add(new Autor(rst.getString("AutorID"), rst.getString("name"),
                    rst.getString("BookName"),rst.getString("Book_ID")));
        }
        return allItems;

    }
}