/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author workplz
 */
public class Connection {

    Properties prop = new Properties();
    InputStream input = null;
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String DBURL;
    public static String DBUSER;
    public static String DBPASS;
    
    private ResultSet result = null;
    java.sql.Connection conn = null;

    public Connection() {
        try {
            
            input = new FileInputStream("config.properties");
            prop.load(input);

            DBURL = "jdbc:mysql://localhost/todolist";
            DBUSER = prop.getProperty("dbuser");
            DBPASS = prop.getProperty("dbpass");;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startConnection() {
        try {
            Class.forName(DRIVER);
            DriverManager.setLoginTimeout(5);
            conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);

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
