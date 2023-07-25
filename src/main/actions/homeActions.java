package main.actions;

import main.dialogs.filePanel;
import main.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class homeActions {

    public static void addButton() {
        home.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new filePanel();
            }
        });
    }

    public static Boolean checkExistingFile(String rowValue) {
        Vector<Vector> data = home.tableModel.getDataVector();
        for (Vector vectorValue :data) {
            if ( vectorValue.get(0).equals(rowValue)) {
                return true;
            }
        } return  false;
    }
}
