package main.dialogs;

import main.actions.explorer;
import main.actions.filePanelActions;
import main.utils.FileExplorer;
import main.utils.recentDataList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class filePanel {

    public JDialog filePanel;
    public JLabel recentFilePanel, lockListPanel, explorerPanel;
    public DefaultTableModel recentTableModel, lockListTableModel;
    public JTable recentTable, lockTable;

    public JButton addButton, removeButton, okButton, cancelButton;





    public filePanel() {
        filePanel = new JDialog();

        filePanel.setTitle("ADD FILES");
        filePanel.setSize(800,600);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = dimension.width/2 - filePanel.getWidth()/2, y = dimension.height/2 - filePanel.getWidth()/2;
        filePanel.setLocation(x,y);
        filePanel.setAlwaysOnTop(true);
        filePanel.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        filePanel.setResizable(false);
        filePanel.setLayout(null);

        // CALL FUNCTIONS
        setRecentFilePanel();
        setRecentTable();
        populateRecentTable();

        setLockListPanel();
        setLockListTable();

        setAddButton();
        filePanelActions.setAddButtonAction(this);

        setRemoveButton();
        filePanelActions.setRemoveButtonAction(this);

        setOkButton();
        filePanelActions.setOkButtonAction(this);

        setCancelButton();
        filePanelActions.setCancelButtonAction(this);

        setExplorerPanel();
        setFileSystem();


        filePanel.setVisible(true);

    }

    public void setRecentFilePanel() {
        recentFilePanel = new JLabel();
        recentFilePanel.setSize(250, 168);
        recentFilePanel.setLocation(10, 10);

        recentFilePanel.setBorder(new LineBorder(Color.BLACK, 2));
        recentFilePanel.setLayout(null);

        filePanel.add(recentFilePanel);
    }

    public void setRecentTable() {
        recentTableModel = new DefaultTableModel();
        recentTableModel.addColumn("RECENT FILES");

        recentTable = new JTable(recentTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(recentTable);
        scrollPane.setSize(242,160);
        scrollPane.setLocation(4,4);
        scrollPane.getViewport().setBackground(Color.WHITE);
        recentFilePanel.add(scrollPane);

        recentTable.setRowHeight(20);
        recentTable.setShowVerticalLines(false);
        recentTable.setFocusable(false);

        recentTable.getTableHeader().setReorderingAllowed(false);
        recentTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

//        recentDataList.getRecentFiles();
    }

    public void setLockListPanel() {
        lockListPanel = new JLabel();
        lockListPanel.setSize(330, 500);
        lockListPanel.setLocation(440, 10);

        lockListPanel.setBorder(new LineBorder(Color.BLACK, 2));
        lockListPanel.setLayout(null);

        filePanel.add(lockListPanel);
    }

    public void setLockListTable() {
        lockListTableModel = new DefaultTableModel();
        lockListTableModel.addColumn("LOCKED FILES");

        lockTable = new JTable(lockListTableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane = new JScrollPane(lockTable);
        scrollPane.setSize(322,492);
        scrollPane.setLocation(4,4);
        scrollPane.getViewport().setBackground(Color.WHITE);
        lockListPanel.add(scrollPane);

        lockTable.setRowHeight(30);
        lockTable.setShowVerticalLines(false);
        lockTable.setFocusable(false);

        lockTable.getTableHeader().setReorderingAllowed(false);
        lockTable.getTableHeader().getColumnModel().getColumn(0).setResizable(false);

    }

    public void populateRecentTable() {
        for (String fileString : recentDataList.getRecentFiles()) {
            recentTableModel.addRow(new Object[] {fileString});
        }
    }

    public void setAddButton() {
        addButton = new JButton("ADD >>");
        addButton.setSize(100, 30);
        addButton.setLocation(300, 240);
        addButton.setFocusable(false);
        addButton.setFocusPainted(false);


        filePanel.add(addButton);
    }
    public void setRemoveButton() {
        removeButton = new JButton("<< REMOVE");
        removeButton.setSize(100, 30);
        removeButton.setLocation(300, 300);
        removeButton.setFocusable(false);
        removeButton.setFocusPainted(false);


        filePanel.add(removeButton);
    }

    public void setOkButton() {
        okButton = new JButton("OK");
        okButton.setSize(100, 30);
        okButton.setLocation(440, 520);
        okButton.setFocusable(false);
        okButton.setFocusPainted(false);


        filePanel.add(okButton);
    }

    public void setCancelButton() {
        cancelButton = new JButton("CANCEL");
        cancelButton.setSize(100, 30);
        cancelButton.setLocation(600, 520);
        cancelButton.setFocusable(false);
        cancelButton.setFocusPainted(false);


        filePanel.add(cancelButton);
    }

    public void setExplorerPanel() {
        explorerPanel = new JLabel();
        explorerPanel.setSize(250, 304);
        explorerPanel.setLocation(10, 200);

        explorerPanel.setBorder(new LineBorder(Color.BLACK, 2));
        explorerPanel.setLayout(null);

        filePanel.add(explorerPanel);
    }

    public void setFileSystem() {

        explorer fileExplorer = new explorer(this);
        fileExplorer.start();

    }




}
