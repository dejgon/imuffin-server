package com.dfc.imuffin.dto;

import java.io.Serializable;

public class PasswordDto implements Serializable {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
