package com.arthur.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

   // @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
  //  public class PasswordResetDto {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @NotNull(message = "First Name is required")
        @Size(min = 2, max = 255)
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 255)
        private String lastName;

        @Email
        @NotNull(message = "Email is required")
        @Column(unique = true)
        private String email;

        @NotNull
        private boolean emailVerified;

        @NotNull(message = "Password is required")
        private String password;

        @Transient
        private String confirmPassword;

        @JsonFormat(pattern = "yyyy-mm-dd")
        @Column(updatable = false)
        private Date createDate;

        @JsonFormat(pattern = "yyyy-mm-dd")
        private Date updateDate;

        @OneToMany(mappedBy = "user")
        private List<BlogPost> blogPosts = new ArrayList<>();

        @OneToMany
        private List<Comment>comments = new ArrayList<>();


        @PrePersist
        protected void onCreate(){
                this.createDate = new Date();
        }
        @PreUpdate
        protected void onUpdate(){
                this.updateDate = new Date();
        }

}
