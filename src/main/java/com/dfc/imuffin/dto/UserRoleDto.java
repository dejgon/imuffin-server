package com.dfc.imuffin.dto;

import java.io.Serializable;
import java.util.List;

public class UserRoleDto implements Serializable {

    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
