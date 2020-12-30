package com.Barker.dto;

public class LoginDto {

    private int id;
    private String userName;

    public LoginDto() {
        super();
    }

    public LoginDto(int id , String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
