package com.example.mandatorydemo.Repositories;

import com.example.mandatorydemo.Config.MySQLConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class blogRepository {

    private Connection con;

    public blogRepository() {
        MySQLConnection msc = new MySQLConnection();
        this.con=msc.create();
    }

    public ResultSet blogList() {
        String selectAllSql="SELECT * FROM mandatorytech.blog";

            try{
                ResultSet rs = Query(selectAllSql);
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }


    private ResultSet Query(String query) throws SQLException {
        Statement stmt = con.createStatement();
        return(stmt.executeQuery(query));
    }

    public void createBlogpost(String blogpost_name, String blogpost, String date) throws SQLException {
        System.out.println(blogpost);
        String sql ="INSERT INTO blog(blogpost_name, blogpost, date)"+"VALUES (?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,blogpost_name);
        preparedStatement.setString(2,blogpost);
        preparedStatement.setString(3,date);
        preparedStatement.execute();
        preparedStatement.close();
    }

}

