/**
 * Author: Gabriel Capobianco
 * Date: May 2021
 * Course: Threaded Project for OOSD (PROJ-207-A) Term 3
 * Project: Workshop 6 --- CMPP-264 Java, JavaFX
 * Function: This class connects to the data base
 */

package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {


    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelExperts", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }



















}
