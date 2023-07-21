package main.model;

import java.io.Serializable;

public class password implements Serializable {
    private static final long serialUID = 1L;
    String password;

    public password(String password) {
        this.password = password;
    }

    public password() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
