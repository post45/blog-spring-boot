package com.arthur.blog.domain;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.security.auth.Refreshable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
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


//    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)


    @OneToMany(mappedBy = "post", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<BlogPost> blogPosts = new ArrayList<>();

    private User createdBy;

    private Date createdDate;
//    @ManyToOne
//    @JoinColumn(name = "user", nullable = false)
//    @NotNull
//    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private BlogPost blogPost;

    @PostPersist
    private void setCreatedDate() {
        createdDate = new Date();
    }

}
