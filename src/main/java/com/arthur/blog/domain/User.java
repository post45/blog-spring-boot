package com.arthur.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

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

        @Email(message = "UserName needs to be an email")
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



        //UserDetails interface method


     @Override
     @JsonIgnore
     public Collection<? extends GrantedAuthority> getAuthorities() {
          return null;
     }

     @Override
     @JsonIgnore
     public String getUsername() {
          return null;
     }

     @Override
     @JsonIgnore
     public boolean isAccountNonExpired() {
          return true;
     }

     @Override
     @JsonIgnore
     public boolean isAccountNonLocked() {
          return true;
     }

     @Override
     @JsonIgnore
     public boolean isCredentialsNonExpired() {
          return true;
     }

     @Override
     @JsonIgnore
     public boolean isEnabled() {
          return true;
     }
}
