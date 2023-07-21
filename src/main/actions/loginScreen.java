package main.actions;

import main.background;

public class loginScreen extends Thread {

    @Override
    public void run() {
        for (int i = 1; i <= 750; i++) {
            background.background.setLocation(i,0);
        }
    }
}
