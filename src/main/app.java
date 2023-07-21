package main;

import javax.swing.*;
import java.awt.*;

public class app {
    public static JFrame mainWindow;

    public static void main(String[] name) {
        mainWindow = new JFrame("LOCKER");
        mainWindow.setSize(720, 400);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dimension.width/2 - mainWindow.getWidth()/2, y = dimension.height/2 - mainWindow.getWidth()/2;
        mainWindow.setLocation(x,y);
        mainWindow.setLayout(null);

        // add login components
//      background.setBackground();
        // add homepage components
        home.setHome();


        mainWindow.setVisible(true);
    }
}
