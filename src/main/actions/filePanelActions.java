package main.actions;

import main.dialogs.filePanel;
import main.home;
import main.utils.FileExplorer;
import main.utils.configArray;
import main.utils.fileOperations;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

@SuppressWarnings("rawtypes")
public class filePanelActions {

    public static void setAddButtonAction(filePanel panelObject) {
        panelObject.addButton.addActionListener(e -> {
            int[] selectedRows = panelObject.recentTable.getSelectedRows();
            for (int rowNumber : selectedRows) {
                String rowValue = (String) panelObject.recentTable.getValueAt(rowNumber, 0);

                if (fileOperations.validateFile(rowValue)) {
                    if (!checkExistingFile(rowValue, panelObject)) {
                        panelObject.lockListTableModel.addRow(new Object[]{ rowValue });
                    }
                }
                if (!checkExistingFile(rowValue, panelObject)) {
                    panelObject.lockListTableModel.addRow(new Object[]{ rowValue });
                }
            }

            String filePath = FileExplorer.getSelectedFile();
            if (fileOperations.validateFile(filePath)) {
                if (!checkExistingFile(filePath, panelObject)) {
                    panelObject.lockListTableModel.addRow(new Object[]{ filePath });
                }
            }

        });
    }

    public static void setRemoveButtonAction(filePanel panelObject) {
        panelObject.removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rowIndices = panelObject.lockTable.getSelectedRows();
                if (rowIndices.length == 0) return;

                configArray.reverse(rowIndices);
                for (int rowNumber : rowIndices) {
                    panelObject.lockListTableModel.removeRow(rowNumber);
                }
            }
        });
    }

    public static Boolean checkExistingFile(String rowValue, filePanel panelObject) {
        Vector<Vector> data = panelObject.lockListTableModel.getDataVector();
        for (Vector vectorValue :data) {
            if ( vectorValue.get(0).equals(rowValue)) {
                return true;
            }
        } return  false;
    }

    public static void setCancelButtonAction(filePanel panelObject) {
        panelObject.cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelObject.filePanel.dispose();
            }
        });
    }

    public static void setOkButtonAction(filePanel panelObject) {
        panelObject.okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Vector> dataVector = panelObject.lockListTableModel.getDataVector();
                for (Vector data : dataVector) {
                    String value = data.get(0).toString();
                    if (!homeActions.checkExistingFile(value)) {
                        home.tableModel.addRow(new Object[] { value, "ACTIVE" });
                    }
                }
                panelObject.filePanel.dispose();
            }
        });
    }



}
