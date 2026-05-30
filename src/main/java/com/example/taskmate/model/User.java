package com.example.taskmate.model;

public class User {

    private int id;
    private String username;
    private String passwordHash;

    public User(String username, String passwordHash){
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public User(int id, String username, String passwordHash){
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public int getId(){return id;}

    public String getUsername(){return username;}
    public void setUserame(String username){this.username = username;}

    public String getPasswordHash(){return passwordHash;}
    public void setPasswordHash(String password){this.passwordHash = passwordHash;}

}
