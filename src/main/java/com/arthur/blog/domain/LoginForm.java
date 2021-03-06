package com.arthur.blog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginForm {

    @NotBlank(message = "Email is required")
    @Size(min = 3, max = 100)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 3, max = 100)
    private String password;
}