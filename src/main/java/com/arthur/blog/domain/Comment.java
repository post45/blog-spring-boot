package com.arthur.blog.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @NotEmpty(message = "*Please write something")
    private String body;

    private User createdBy;

    private Date createdDate;

    @ManyToOne
    //@JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    @NotNull
    private BlogPost blogPost;

    @ManyToOne
    //@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;


    @PostPersist
    private void setCreatedDate() {
        createdDate = new Date();
    }
}
