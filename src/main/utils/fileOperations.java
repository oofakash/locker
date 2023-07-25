package main.utils;

import main.model.password;

import java.io.*;

public class fileOperations {
    public static String getPassword() {
        try {
            File passwordFile = new File("E:/Web Projects/LockerDir/password.log");
            if(passwordFile.exists()) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(passwordFile));
                password password = (password) in.readObject();
                return password.getPassword();
            } else {
                passwordFile.createNewFile();
                password password = new password("akash");
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(passwordFile));
                out.writeObject(password);
                return password.getPassword();
            }
        } catch (Exception ignored) {

        }
        return null;
    }

    public static Boolean validateFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }

    public static void checkAppDirectory() {
        try {
            File appDir = new File("E:/Web Projects/LockerDir");
            if (!appDir.exists()) {
                appDir.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
