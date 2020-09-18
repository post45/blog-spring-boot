package com.arthur.blog.exceptions;

public class UserNameAlreadyExistsResponse {
    private String email;

    public UserNameAlreadyExistsResponse(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
