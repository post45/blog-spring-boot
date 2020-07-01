package com.arthur.blog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    private String id;
}
