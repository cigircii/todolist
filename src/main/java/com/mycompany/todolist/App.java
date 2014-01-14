package com.mycompany.todolist;

import javax.swing.UIManager;
import view.main;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        main v = new main();
        v.setLocationRelativeTo(null);
        v.isAlwaysOnTop();

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
