package com.model.bean;

public class Account {
    private int id;
    public String username;
    public String password;
    public String firstname;
    public String lastname;
    public boolean role;
    public Account(String username,String password,String firstname,String lastname,boolean role){
        this.username=username;
        this.password=password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }
    public Account(int id,String username,String password,String firstname,String lastname,boolean role){
        this.id = id;
        this.username=username;
        this.password=password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public int getId() {
        return id;
    }
}
