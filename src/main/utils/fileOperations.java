package main.utils;

import main.model.password;

import java.io.*;

public class fileOperations {
    public static String getPassword() {
        try {
            File passwordDir = new File("E:/Web Projects/Password");
            if(passwordDir.exists()) {
                File passwordFile = new File("E:/Web Projects/Password/password.log");
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(passwordFile));
                password password = (password) in.readObject();
                return password.getPassword();
            } else {
                passwordDir.mkdir();
                File passwordFile = new File("E:/Web Projects/Password/password.log");
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
}
