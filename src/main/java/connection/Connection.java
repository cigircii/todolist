/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author workplz
 */
public class Connection {

    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String DBURL;
    public static String DBUSER;
    public static String DBPASS;
    private ResultSet result = null;
    java.sql.Connection conn = null;

    public Connection() {
        DBURL = "jdbc:mysql://localhost/todolist";
        DBUSER = "root";
        DBPASS = "";
    }

    public void startConnection() {
        try {
            Class.forName(DRIVER);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

            System.out.println("Connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public java.sql.Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn = null;
    }

    public ResultSet performSelect(PreparedStatement prdstmt) throws SQLException {
        result = prdstmt.executeQuery();

        return result;
    }
}
