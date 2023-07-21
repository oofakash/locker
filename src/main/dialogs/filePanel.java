package main.dialogs;

import javax.swing.*;
import java.awt.*;

public class filePanel {

    public filePanel() {
        JDialog filePanel = new JDialog();

        filePanel.setTitle("ADD FILES");
        filePanel.setSize(480,320);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dimension.width/2 - filePanel.getWidth()/2, y = dimension.height/2 - filePanel.getWidth()/2;
        filePanel.setLocation(x,y);
        filePanel.setAlwaysOnTop(true);
        filePanel.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        filePanel.setResizable(false);

        filePanel.setVisible(true);

    }
}
