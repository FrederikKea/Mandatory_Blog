package com.example.mandatorydemo.Config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MySQLConnection {

    //Her ligger oplysningerne brugt til at forbinde til vores database.
    // De er gemt som datatypen String og bruges af metoderne.
    private String db_host = "den1.mysql5.gear.host:3306";
    private String db_database = "mandatorytech";
    private String db_user = "mandatorytech";
    private String db_password = "Ry0RM_?mEBgG";
    private Connection con;

    // constructor
    public MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // create db connection. returns null on failure
    public Connection create() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + db_host + "/" + db_database, db_user, db_password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void connClose() throws SQLException {
        this.con.close();
    }
}
