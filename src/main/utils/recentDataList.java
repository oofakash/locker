package main.utils;

import java.util.ArrayList;
import java.util.List;

public class recentDataList {

    private static List<String> recentFiles = new ArrayList<>();

    public static List<String> getRecentFiles() {
        return recentFiles;
    }

    public static void populateRecentFileData() {
        recentFiles.add("E:\\Web Projects\\Temp\\testA.txt");
        recentFiles.add("E:\\Web Projects\\Temp\\testB.txt");
        recentFiles.add("E:\\Web Projects\\Temp\\testC.txt");
        recentFiles.add("E:\\Web Projects\\Temp\\testD.txt");
    }

}
