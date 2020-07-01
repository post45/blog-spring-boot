package com.arthur.blog.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginForm {

    @NotNull(message = "Email is required")
    @Size(min = 3, max = 100)
    private String email;

    @NotNull(message = "Passwordmis required")
    @Size(min = 3, max = 100)
    private String password;
}