package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {

    public static final String load_Driver="com.mysql.cj.jdbc.Driver";
    public static String URL="jdbc:mysql://localhost:3306/truckmgt";
    public static String USER_NAME="root";
    public static String PASSWORD="Somnath@123";


    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(URL,USER_NAME,PASSWORD);
    }


}
