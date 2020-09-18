package com.arthur.blog.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.security.auth.Refreshable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "posts")
public class BlogPost {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 20)
    private String title;

    @NotNull
    @Size(min = 5, max = 1000)
    private String body;


    @NotNull
    private long createdBy;
    //wrapper class
    //INteger int
    //Double double
    //Long long


    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "users", referencedColumnName = "users")
    private User user;


    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date createDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();


    @PrePersist
    protected void onCreate(){
        this.createDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateDate = new Date();
    }


}
