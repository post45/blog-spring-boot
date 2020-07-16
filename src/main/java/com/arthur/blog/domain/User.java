package com.arthur.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
//import com.memorynotfound.spring.security.constraint.ValidPassword;

import javax.persistence.*;
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

        @NotNull(message = "Last name is required")
        @Size(min = 2, max = 255)
        private String lastName;

        @NotNull(message = "Email is required")
        @Size(min = 2, max = 255)
        private String email;

        @NotNull
        private boolean emailVerified;

        @NotNull(message = "Password is required")
        @Size(min = 4, max = 300)
        private String password;

        @Transient
        private String confirmPassword;

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        private Date createDate;

        @OneToMany(mappedBy = "user")
        private List<BlogPost> blogPosts = new ArrayList<>();

        @PostPersist
        private void setCreatedDate() {
            createDate = new Date();
        }

}
