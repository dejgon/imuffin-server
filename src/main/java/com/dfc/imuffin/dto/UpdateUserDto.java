package com.dfc.imuffin.dto;

import java.io.Serializable;

public class UpdateUserDto implements Serializable {

    private UserDto user;
    private PasswordDto password;


    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PasswordDto getPassword() {
        return password;
    }

    public void setPassword(PasswordDto password) {
        this.password = password;
    }
}
