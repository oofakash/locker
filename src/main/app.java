package main;
import javax.swing.*;
import java.awt.*;

import main.dialogs.filePanel;
import main.utils.fileOperations;
import main.utils.recentDataList;


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
        background.setBackground();

        // add homepage components
        home.setHome();

        // check for app directory and if not make one
        fileOperations.checkAppDirectory();

        // add recent file data
        recentDataList.populateRecentFileData();

//        new filePanel();


        mainWindow.setVisible(true);
    }
}
