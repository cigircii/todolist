/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import connection.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author workplz
 */
public class TaskDAO {

    Connection conn = new Connection();

    public void deleteTask(int id) throws SQLException {
        PreparedStatement prdstmt = null;
        String sql = "DELETE FROM `tasks` WHERE id=?";

        conn.startConnection();
        prdstmt = conn.getConnection().prepareStatement(sql);

        prdstmt.setInt(1, id);
        prdstmt.executeUpdate();
        System.out.println("deleted");

        if (conn != null) {
            conn.close();
        }
    }

    public void updateTask(Task task) throws SQLException {
        PreparedStatement prdstmt = null;

        String sql = "UPDATE `tasks` SET `voor`=?, `wat`=?, `waneer`=? WHERE `id`=?";

        conn.startConnection();
        prdstmt = conn.getConnection().prepareStatement(sql);

        prdstmt.setString(1, task.getVoor());
        prdstmt.setString(2, task.getWat());
        prdstmt.setString(3, task.getWaneer());
        prdstmt.setInt(4, task.getId());

        prdstmt.executeUpdate();

        System.out.println("updated");

        if (conn != null) {
            conn.close();
        }
    }

    public void insertTask(Task task) throws SQLException {
        PreparedStatement prdstmt = null;

        String sql = "INSERT INTO `tasks` (`voor`,`wat`,`waneer`) VALUES (?, ?, ?)";

        conn.startConnection();
        prdstmt = conn.getConnection().prepareStatement(sql);

        prdstmt.setString(1, task.getVoor());
        prdstmt.setString(2, task.getWat());
        prdstmt.setString(3, task.getWaneer());

        prdstmt.executeUpdate();

        System.out.println("inserted");

        if (conn != null) {
            conn.close();
        }
    }

    public void empty() throws SQLException {
        ResultSet rs;
        PreparedStatement prdstmt;

        String sql = "DELETE FROM `todolist`.`tasks`";

        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(sql);
        prdstmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Emptied all tasks");

    }

    public List<Task> readAllTasks() throws SQLException {
        List<Task> list = new LinkedList<Task>();

        ResultSet rs;
        PreparedStatement prdstmt;

        String query = "SELECT * FROM tasks;";
        conn.startConnection();

        prdstmt = conn.getConnection().prepareStatement(query);
        rs = conn.performSelect(prdstmt);

        while (rs.next()) {
            Task tempTask = new Task();
            tempTask.setId(rs.getInt("id"));
            tempTask.setVoor(rs.getString("voor"));
            tempTask.setWat(rs.getString("wat"));
            tempTask.setWaneer(rs.getString("waneer"));
            list.add(tempTask);
        }

        if (conn != null) {
            conn.close();
        }

        System.out.println(list);

        return list;

    }
}
