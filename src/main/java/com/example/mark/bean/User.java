package com.example.mark.bean;

import lombok.Data;

@Data
public class User {
    private String uid;
    private String uname;
    private Double money;
    private String pwd;
    private char isAdmin;
}
