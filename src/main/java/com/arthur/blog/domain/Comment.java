package com.arthur.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

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

    @CreatedBy
    private int createdBy;

    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date createDate;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updateDate;

    @ManyToOne
    //@JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    @NotNull
    private BlogPost blogPost;

    @ManyToOne
    //@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
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
