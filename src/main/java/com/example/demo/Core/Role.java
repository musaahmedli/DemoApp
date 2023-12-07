package com.example.demo.Core;


public enum Role {
    ADMIN("ADMIN"),
    NORMALUSER("NORMALUSER"),
    INSTRUCTOR("INSTRUCTOR"),
    SUPERUSER("SUPERUSER");

    private String roleId;
    private Role(String roleId){
        this.roleId = roleId;
    }

    public String getRoleid(){
        return roleId;
    }

}
