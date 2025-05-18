/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.io.InputStream;

/**
 *
 * @author fakhr
 */
public class DBUtil {

    private static String jdbcURL;
    private static String jdbcUsername;
    private static String jdbcPassword;

    static {
        try (InputStream input = new FileInputStream("C:/studentManagementConfig/db.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            jdbcURL = prop.getProperty("db.url");
            jdbcUsername = prop.getProperty("db.username");
            jdbcPassword = prop.getProperty("db.password");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load database configuration", e);
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (jdbcURL == null) {
            throw new SQLException("JDBC URL is null — check db.properties.");
        }
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }
}
