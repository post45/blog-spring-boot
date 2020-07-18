package com.arthur.blog.domain;


import lombok.Data;
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
    @Size(min = 50, max = 1000)
    private String body;

    @NotNull
    @Size(min = 2, max = 20)
    private String title;


    @OneToMany(mappedBy = "posts", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<BlogPost> blogPosts = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "posts")
    private User user;


    @OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;

    private User createdBy;

    private Date createdDate;


    @PostPersist
    private void setCreatedDate() {
        createdDate = new Date();
    }

}
