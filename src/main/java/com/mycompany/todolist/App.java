package com.mycompany.todolist;

import javax.swing.UIManager;
import view.main;

/**
 * @author workplz
 *
 */
public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            main v = new main();
            v.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
