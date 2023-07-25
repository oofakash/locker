package main.actions;

import main.dialogs.filePanel;
import main.utils.FileExplorer;

import javax.swing.*;

public class explorer extends Thread {

    public filePanel filePanel;
    public explorer (filePanel filePanel) {
        this.filePanel = filePanel;
    }

    @Override
    public void run() {
        setFileSystem();
    }

    public void setFileSystem() {
        JScrollPane fileScrollPane = FileExplorer.getFileExplorerScrollPanel();
        fileScrollPane.setSize(248, 300);
        fileScrollPane.setLocation(1, 2);

        filePanel.explorerPanel.add(fileScrollPane);

    }
}
