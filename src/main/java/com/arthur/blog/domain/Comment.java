package com.arthur.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;

    @CreatedBy
    private int createdBy;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date createDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

    @ManyToOne
   // @JoinColumn(name = "posts", referencedColumnName = "posts", nullable = false)
    private BlogPost blogPost;

    @ManyToOne
    //@JoinColumn(name = "users", referencedColumnName = "users", nullable = false)
    private User user;


    @PrePersist
    protected void onCreate(){
        this.createDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updateDate = new Date();
    }

}
