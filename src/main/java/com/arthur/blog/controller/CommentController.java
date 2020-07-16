package com.arthur.blog.controller;

import com.arthur.blog.service.CommentService;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;

@RestController
@RequestMapping(path = "api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
}
