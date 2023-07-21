package main.actions;

import main.dialogs.filePanel;
import main.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeActions {

    public static void addButton() {
        home.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new filePanel();
            }
        });
    }
}
