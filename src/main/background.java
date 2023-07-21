package main;

import main.actions.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class background {

    public static JLabel background, placeholder, errorTxt;
    public static JButton loginButton, exitButton;
    public static JPasswordField passwordField;
    public static void setBackground() {
        background = new JLabel();
        background.setSize(720, 400);
        background.setLocation(0,0);
        background.setBackground(Color.LIGHT_GRAY);
        background.setOpaque(true);
        background.setLayout(null);

        app.mainWindow.add(background);

        loginButton();
        exitButton();

        addPassword();
        addPlaceholder();
        changePlaceholder();

        actions.exitButton();
        actions.loginButton();

        altLoginKey();

        displayError();
    }

    public static void loginButton() {
        loginButton = new JButton("LOGIN");
        loginButton.setSize(80, 20);
        loginButton.setLocation(280,250);
        background.add(loginButton);
    }
    public static void exitButton() {
        exitButton = new JButton("EXIT");
        exitButton.setSize(80, 20);
        exitButton.setLocation(380,250);
        background.add(exitButton);
    }

    public static void addPassword() {
        passwordField = new JPasswordField();
        passwordField.setLocation(200, 200);
        passwordField.setSize(340, 30);
        passwordField.setLayout(null);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 25));

        background.add(passwordField);
    }

    public static void addPlaceholder() {
        placeholder = new JLabel("   Enter your passcode   ");
        placeholder.setSize(140, 25);
        passwordField.add(placeholder);
    }

    public static void changePlaceholder() {
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                changeVis();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                changeVis();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                changeVis();
            }
        });
    }

    public static void changeVis() {
         char[] pass = passwordField.getPassword();
        placeholder.setVisible(pass.length == 0);
    }

    public static void displayError() {
        errorTxt = new JLabel("INCORRECT PASSWORD");
        errorTxt.setSize(140, 25);
        errorTxt.setLocation(200, 300);
        errorTxt.setLayout(null);
        errorTxt.setForeground(Color.RED);
        errorTxt.setFont(new Font("Arial", Font.PLAIN, 10));
        errorTxt.setVisible(false);

        background.add(errorTxt);
    }

    public static void altLoginKey() {
        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

             }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if(code == KeyEvent.VK_ENTER) {
                    loginButton.doClick();;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


}
