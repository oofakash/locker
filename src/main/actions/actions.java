package main.actions;

import main.background;
import main.utils.fileOperations;

public class actions {
    public static void exitButton() {
        background.exitButton.addActionListener(e -> System.exit(0));
    }
    public static void loginButton() {
        background.loginButton.addActionListener(e -> {
            char[] passArr = background.passwordField.getPassword();
            String pass = String.valueOf(passArr);
            if(pass.equals(fileOperations.getPassword())) {
                changeLoginScreen();
                background.errorTxt.setVisible(false);
            } else {
                background.errorTxt.setVisible(true);
            }
        });

    }

    public static void changeLoginScreen() {
        loginScreen loginScreen = new loginScreen();
        loginScreen.start();
    }
}
