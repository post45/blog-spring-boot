package com.arthur.blog.exceptions;

public class InvalidLoginResponse {

    private String login;
    private String password;

    public InvalidLoginResponse(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public InvalidLoginResponse() {
        this.login = "invalid login";
        this.password = "invalid password";
    }

    private String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
}
